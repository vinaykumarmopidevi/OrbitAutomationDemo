package com.orbit.reporting.automation.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Flags.Flag;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.FlagTerm;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;

import org.apache.poi.ss.formula.ptg.Deleted3DPxg;
import org.xml.sax.SAXException;

public class ReadMailSample {
	Properties properties = null;
	private Session session = null;
	private Store store = null;
	private Folder inbox = null;
	//private String userName = "vinaya.mopidi@orbitanalytics.com";// provide user name
	//private String password = "Data@123";// provide password
	private String str;
	String loginCredentials;
	String userActivation;
	private String result;
	
	public String readMails(String subject,String userName, String password) {
		properties = new Properties();
		properties.setProperty("mail.host", "imap.gmail.com");
		properties.setProperty("mail.port", "995");
		properties.setProperty("mail.transport.protocol", "imaps");
		session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		});
		try {
			store = session.getStore("imaps");
			store.connect();
			inbox = store.getFolder("INBOX");
			inbox.open(Folder.READ_WRITE);
			Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
			
			System.out.println("Number of mails = " + messages.length);
			for (int i = 0; i < messages.length; i++) {
				Message message = messages[i];
				Address[] from = message.getFrom();
				String mail_subject=message.getSubject();
				if(subject.equalsIgnoreCase(mail_subject)){
				System.out.println("-------------------------------");
				System.out.println("Date : " + message.getSentDate());
				System.out.println("From : " + from[0]);
				System.out.println("Subject: " + message.getSubject());
				System.out.println("Content :");
				String msg= processMessageBody(message);
					message.setFlag(Flags.Flag.DELETED,true);
				return msg;
				}
			}
			inbox.close(true);
			store.close();
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return "";
	}

	public String  processMessageBody(Message message) {
		try {
			Object content = message.getContent(); // check for string // then
													// check for multipart
			if (content instanceof String) {
				System.out.println(content);
			} else if (content instanceof Multipart) {
				Multipart multiPart = (Multipart) content;
				return procesMultiPart(multiPart);
			} else if (content instanceof InputStream) {
				InputStream inStream = (InputStream) content;
				int ch;
				while ((ch = inStream.read()) != -1) {
					System.out.write(ch);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return "";
	}

	public String procesMultiPart(Multipart content) {
		try {
			int multiPartCount = content.getCount();
			for (int i = 0; i < multiPartCount; i++) {
				BodyPart bodyPart = content.getBodyPart(i);
				Object o;
				o = bodyPart.getContent();
				if (o instanceof String) {
					//System.out.println(o);
					str= (String)o;
				} 
				
				if (o instanceof Multipart) {
					procesMultiPart((Multipart) o);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return str;
	}
	
	public String getUserActivation(String userName, String password) {
		boolean flag=false;
		//http://qa1.orbit8.com:8010/reporting/registrationConfirm?activationKey=73561007013176258305
		// ReadMailSample sample = new ReadMailSample();
		while(!flag ){
		 result = readMails("User Activation",userName,password);
		 if(result.isEmpty()){
			 try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }else{
			 flag=true;
		 }
		}
		
		System.out.println(result);
		String[] arr1 = result.split("activationKey=");
		String[] arr2 = arr1[1].split("\" style=");
		userActivation = arr2[0];
		return userActivation;
	}

	public String getLoginCredentials_Passwrod(String userName, String password) {
		// ReadMailSample sample = new ReadMailSample();
		boolean flag=false;
		while(!flag ){
			result = readMails("Login Credentials",userName,password);
			 if(result.isEmpty()){
				 try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }else{
				 flag=true;
			 }
			}
		System.out.println(result);
		// System.out.println(result);
		String[] arr1 = result.split("Password:");
		String[] arr2 = arr1[1].split("sans-serif;\">");
		String[] arr3 = arr2[1].split("</td>");
		// System.out.println(arr3[0]);
		loginCredentials = arr3[0];
		
	
		return loginCredentials;

	}
	
	public String getLoginCredentials_Username(String userName, String password) {
		// ReadMailSample sample = new ReadMailSample();
		String result = readMails("Login Credentials",userName,password);
		// System.out.println(result);
		String[] arr1 = result.split("User Name:");
		String[] arr2 = arr1[1].split("sans-serif;\">");
		String[] arr3 = arr2[1].split("</td>");
		// System.out.println(arr3[0]);
		loginCredentials = arr3[0];
		return loginCredentials;

	}
	
	
	/*public void setUserActivation(String userActivation) {
		String filepath = System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\applicationInfo.xml";
		try {
			GetNameAsAttr.setXmlValue("/applicationInfo/InfoUser/@username", userActivation, filepath);
		} catch (XPathExpressionException | ParserConfigurationException | SAXException | IOException
				| TransformerException e) {
			
			e.printStackTrace();
		}
		//this.userActivation = userActivation;
	}
	public void setLoginCredentials(String loginCredentials) {
		String filepath = System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\applicationInfo.xml";
		try {
			GetNameAsAttr.setXmlValue("/applicationInfo/InfoUser/@username", loginCredentials, filepath);
		} catch (XPathExpressionException | ParserConfigurationException | SAXException | IOException
				| TransformerException e) {
			
			e.printStackTrace();
		}
		//this.loginCredentials = loginCredentials;
	}*/
}
