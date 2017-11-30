package com.orbit.reporting.automation.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


public class GetNameAsAttr {

	public static void setXmlValue(String xpath, String value, String filepath)
			throws XPathExpressionException, ParserConfigurationException,
			SAXException, IOException, TransformerException {
		File fXmlFile = new File(filepath);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);

		setValue(doc, xpath, value,filepath);

	}

	public static Node getNode(Document doc, String XPathQuery,String filepath)
			throws XPathExpressionException {
		XPath xpath = XPathFactory.newInstance().newXPath();
		XPathExpression expr = xpath.compile(XPathQuery);
		Object result = expr.evaluate(doc, XPathConstants.NODE);
		Node node = (Node) result;
		if (node != null)
			return node;
		throw new XPathExpressionException("No node list found for "
				+ XPathQuery);
	}

	public static void setValue(final Document doc, final String XPathQuery,
			final String value,String filepath) throws XPathExpressionException, TransformerException {

		Node node = getNode(doc, XPathQuery,filepath);
		if (node != null) {
			
		//	node.setTextContent(value);
			node.setNodeValue(value);
		} else {
			throw new XPathExpressionException("No node found for "
					+ XPathQuery);
		}
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
	
		Transformer transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
		DOMSource domSource = new DOMSource(doc);

		StreamResult streamResult = new StreamResult(new File(filepath));
		transformer.transform(domSource, streamResult);

		
	}

	public static void setText(String filepath) throws SAXException, IOException, ParserConfigurationException, XPathExpressionException, TransformerException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		Document document = dbf.newDocumentBuilder().parse(
				new File(filepath));

		XPathFactory xpf = XPathFactory.newInstance();
		XPath xpath = xpf.newXPath();
		XPathExpression expression = xpath.compile("//Passenger/@FirstName");

		Node b13Node = (Node) expression
				.evaluate(document, XPathConstants.NODE);
		b13Node.getParentNode().removeChild(b13Node);

	//	TransformerFactory tf = TransformerFactory.newInstance();
		//Transformer t = tf.newTransformer();
		//t.transform(new DOMSource(document), new StreamResult(System.out));
		
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();

		Transformer transformer = transformerFactory.newTransformer();
		//transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		DOMSource domSource = new DOMSource(document);

		StreamResult streamResult = new StreamResult(new File(filepath));
		transformer.transform(domSource, streamResult);


		
	}

	public  String convertXMLFileToString(String fileName) 
	{ 
	    try { 
	        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance(); 
	        InputStream inputStream = new FileInputStream(new File(fileName)); 
	      
	        org.w3c.dom.Document doc = documentBuilderFactory.newDocumentBuilder().parse(inputStream); 
	        StringWriter stw = new StringWriter(); 
	        Transformer serializer = TransformerFactory.newInstance().newTransformer();
	      //  serializer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
	        serializer.transform(new DOMSource(doc), new StreamResult(stw)); 
	        return stw.toString(); 
	    } catch (Exception e) { 
	        e.printStackTrace(); 
	    } 
	    return null; 
	}
	
	public static String getText(String xpathkey,String filepath) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException{
		File fXmlFile = new File(filepath);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(fXmlFile);
		XPathFactory xPathfactory = XPathFactory.newInstance();
		XPath xpath = xPathfactory.newXPath();
		XPathExpression expr = xpath.compile(xpathkey);
		
		return (String)expr.evaluate(doc, XPathConstants.STRING);
		
	}
	
	
	
	public String getTextString(String xpathkey,String xmlRecords) throws Exception{
	

		    DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		    InputSource is = new InputSource();
		    is.setCharacterStream(new StringReader(xmlRecords));
		    Document doc = builder.parse(is);
			XPathFactory xPathfactory = XPathFactory.newInstance();
			XPath xpath = xPathfactory.newXPath();
			XPathExpression expr = xpath.compile(xpathkey);
			Object result=expr.evaluate(doc, XPathConstants.STRING);
			
			if(result==null){
				return "XPathNotFound";
			}
			return (String)result;

		   

		  }
	public static String readFileAsString(String filePath) throws java.io.IOException{
	    byte[] buffer = new byte[(int) new File(filePath).length()];
	    BufferedInputStream f = null;
	    try {
	        f = new BufferedInputStream(new FileInputStream(filePath));
	        f.read(buffer);
	        if (f != null) try { f.close(); } catch (IOException ignored) { }
	    } catch (IOException ignored) { 
	    	System.out.println("File not found or invalid path.");
	    	}
	    return new String(buffer);
	}

	public static void getAllElements1()
			throws SAXException, IOException, ParserConfigurationException, TransformerException {

		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
		String filepath = System.getProperty("user.dir")+"\\src\\test\\resources\\msg_data.xml";
		Document document = docBuilder.parse(new File(filepath));
		doSomething(document.getDocumentElement());
	}

	public static void doSomething(Node node) {
		// do something with the current node instead of System.out
		System.out.println(node.getNodeName());

		NodeList nodeList = node.getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node currentNode = nodeList.item(i);
			if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
				// calls this method for all the children which is Element
				doSomething(currentNode);
			}
		}
	}	
	


	public static void getAllElements2(String[] args)
			throws SAXException, IOException, ParserConfigurationException, TransformerException {

		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
		String filepath = System.getProperty("user.dir")+"\\src\\test\\resources\\msg_data.xml";
		Document document = docBuilder.parse(new File(filepath));

		NodeList nodeList = document.getElementsByTagName("*");
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				// do something with the current element
				System.out.println(node.getNodeName());
			}
		}
	}

		
	
}
