package com.orbit.reporting.automation.page;

public interface Constants {
	// user
	String newUserBtn = "return Ext.ComponentQuery.query(\"button[handler='onNewUserBtn']\")[0].id";
	String saveBtn = "return Ext.ComponentQuery.query(\"button[handler='onSaveBtn']\")[0].id";
	String searchIcon = "return Ext.ComponentQuery.query(\"gridcolumn[itemId='iconCol']\")[0].id";
	String textfield_login = "return Ext.ComponentQuery.query(\"textfield[itemId='login']\")[0].id";
	String yes_btn = "return Ext.ComponentQuery.query(\"button[text='Yes']\")[0].id";
	String btn_onShowSearch = "return Ext.ComponentQuery.query(\"tool[callback='onShowSearch']\")[2].id";
	String btn_saveChanges = "return Ext.ComponentQuery.query(\"button[text='Save']\")[3].id";
	// Domain
	String btn_CreateDomain = "return Ext.ComponentQuery.query(\"button[handler='OnAddDomain']\")[0].id";
	String btn_SaveDomain = "return Ext.ComponentQuery.query(\"button[handler='saveMetaObject']\")[0].id";

	String textFieldName2 = "return Ext.ComponentQuery.query(\"textfield[itemId='nameField']\")[1].id";
	String textareaFieldDesc2 = "return Ext.ComponentQuery.query(\"textareafield[reference='descriptionField']\")[1].id";
	String saveFldBtn = "return Ext.ComponentQuery.query(\"button[text='Save']\")[1].id";
	String treecolumn = "//div[@class='x-grid-cell-inner x-grid-cell-inner-treecolumn']/span[contains(text(),'$$$')]";
	String importObjects = "return Ext.ComponentQuery.query(\"menuitem[text='Import Objects']\")[0].id";
	String schemaName = "return Ext.ComponentQuery.query(\"combo[reference='schemaName']\")[0].id";
	String tableName = "return Ext.ComponentQuery.query(\"textfield[reference='tableName']\")[0].id";
	String tablesbtn = "return Ext.ComponentQuery.query(\"button[reference='tablesbtn']\")[0].id";
	String gridItem = "//table[@class='x-grid-item']//div[starts-with(text(),'$$$')]";
	String moveTable = "return Ext.ComponentQuery.query(\"button[text='>']\")[0].id";
	String btn_import = "return Ext.ComponentQuery.query(\"button[text='Import']\")[0].id";
	String expander = treecolumn + "/preceding-sibling::div[contains(@class,'x-tree-expander')]";
	String canvas = "return Ext.ComponentQuery.query(\"container[componentCls='X-container']\")[0].id";
	String fitButton = "return Ext.ComponentQuery.query(\"button[itemId='fitBtn']\")[0].id";
	String btn_relationship = "return Ext.ComponentQuery.query(\"button[handler='onOkClick']\")[0].id";
	String btn_saveDomain = "return Ext.ComponentQuery.query(\"button[tooltip='Save Domain']\")[0].id";
	String logicalModel = "return Ext.ComponentQuery.query(\"menuitem[text='New Logical Model']\")[0].id";
	String businessObject = "return Ext.ComponentQuery.query(\"menuitem[text='New Business Object']\")[0].id";
	String combo = "return Ext.ComponentQuery.query(\"combo[itemId='dataSourceCombo']\")[0].id";
	String ext = "return Ext.ComponentQuery.query(\"boundlist[text='iorb4']\")[0].id";
	String expandDomainTree = "return Ext.ComponentQuery.query(\"tool[handler='expandDomainTree']\")[0].id";
	String newBusinessComp = "return Ext.ComponentQuery.query(\"treecolumn[stateId='h1']\")[1].id";
	String newCategory = "return Ext.ComponentQuery.query(\"menuitem[text='New Category']\")[0].id";
	String columnsDragDrop = "return Ext.ComponentQuery.query(\"gridview[id^='gridview-']\")[4].id";
	
	String reports_drag_columns = "return Ext.ComponentQuery.query(\"treecolumn[textAlign='left']\")[1].id";
	
	
	

	// Reports
	String btn_Createeport = "return Ext.ComponentQuery.query(\"button[itemId='newReportBtn']\")[0].id";
	String openBusinessObjectWindow = "return Ext.ComponentQuery.query(\"orbit-tool[callback='openBusinessObjectWindow']\")[0].id";
	String textfield_BusinessObject = "return Ext.ComponentQuery.query(\"textfield[itemId='name']\")[0].id";
	String btn_BusinessObject = "return Ext.ComponentQuery.query(\"button[text='Ok']\")[0].id";
	String expandTree = "return Ext.ComponentQuery.query(\"tool[handler='expandTree']\")[0].id";
	String onExpandAll = "return Ext.ComponentQuery.query(\"tool[handler='onExpandAll']\")[0].id";
	String onExpandAll0 = "return Ext.ComponentQuery.query(\"tool[handler='expandAll']\")[0].id";
	String onExpandAll1 = "return Ext.ComponentQuery.query(\"tool[handler='expandAll']\")[1].id";
	String onRefreshBusinessObject = "return Ext.ComponentQuery.query(\"tool[handler='onRefreshBusinessObject']\")[0].id";
	String btn_reportRun = "return Ext.ComponentQuery.query(\"button[cls='report-run-button']\")[1].id";
	String searchItems = "return Ext.ComponentQuery.query(\"tool[tooltip='Search for items to add']\")[0].id";
	String editReport = "return Ext.ComponentQuery.query(\"menuitem[text='Edit']\")[0].id";
	String reportOPtions = "return Ext.ComponentQuery.query(\"button[handler='onOptionsMenu']\")[0].id";
	String reportToast_ProcessID = "return Ext.ComponentQuery.query(\"toast\")[0].id";
	String btn_reportsDownloads = "return Ext.ComponentQuery.query(\"button[handler='showDownloads']\")[0].id";
	String btn_saveReport = "return Ext.ComponentQuery.query(\"button[tooltip='Save Report']\")[0].id";

	String generate_privateLink = "return Ext.ComponentQuery.query(\"radio[boxLabel='Private']\")[0].id";
	String generate_publicLink = "return Ext.ComponentQuery.query(\"radio[boxLabel='Public']\")[0].id";
	String generate_button = "return Ext.ComponentQuery.query(\"button[handler='onGenerateClick']\")[0].id";
	String runReportMain_button = "return Ext.ComponentQuery.query(\"button[handler='runReportMain']\")[0].id";
	String close_button = "return Ext.ComponentQuery.query(\"button[text='Close']\")[0].id";
	String fld_treeExpander = "return Ext.ComponentQuery.query(\"treecolumn[expanderCls='x-tree-expander']\")[5]";

	// Data source
	String datasource = "return Ext.ComponentQuery.query(\"button[handler='OnAddDataSource']\")[0].id";
	String cancel_datasource = "return Ext.ComponentQuery.query(\"button[handler='cancelDataSource']\")[0].id";
	String testConn = "return Ext.ComponentQuery.query(\"button[handler='checkConnectionStatus']\")[0].id";
	String datasource_conn_status = "return Ext.ComponentQuery.query(\"textareafield[itemId='connectionStatusField']\")[0].id";

	
	String getElementText ="return Ext.getCmp('$$$').getValue()";
			
}
