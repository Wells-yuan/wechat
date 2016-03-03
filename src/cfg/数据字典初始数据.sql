#------------------字典表分组--------------------------#

use htgl;

/*-----------------合同状态-dic_contract_state-------------------------*/
delete from t_dictionary where Groupname="dic_contract_state";
insert into t_dictionary values('110000001','dic_contract_state','合同状态','insert','等待会签',0,1,'0',null,'等待会签');
insert into t_dictionary values('110000002','dic_contract_state','合同状态','sign','会签',1,2,'1',null,'会签');
insert into t_dictionary values('110000003','dic_contract_state','合同状态','execute','执行',2,3,'2',null,'执行');
insert into t_dictionary values('110000004','dic_contract_state','合同状态','stop','终止',3,4,'3',null,'终止');
insert into t_dictionary values('110000005','dic_contract_state','合同状态','finish','完结',4,5,'4',null,'完结');
insert into t_dictionary values('110000006','dic_contract_state','合同状态','tally','流水',5,0,'5',null,'合同流水');

/*-----------------合同分类-dic_contract_type-------------------------*/
delete from t_dictionary where Groupname="dic_contract_type";
insert into t_dictionary values('120000001','dic_contract_type','合同分类','ZBHT','总包合同',1,1,'1',null,'总包');
insert into t_dictionary values('120000002','dic_contract_type','合同分类','JQFB','基切分包',2,2,'2',null,'基切分包');
insert into t_dictionary values('120000003','dic_contract_type','合同分类','RWS','基切任务书',3,3,'2',null,'基切任务书');
insert into t_dictionary values('120000004','dic_contract_type','合同分类','NZHT','内招分包',4,4,'2',null,'内招分包');
insert into t_dictionary values('120000005','dic_contract_type','合同分类','LWHT','劳务合同',5,7,'2',null,'劳务合同');
insert into t_dictionary values('120000006','dic_contract_type','合同分类','TSHT','特殊合同',6,6,'2',null,'特殊合同');
insert into t_dictionary values('120000007','dic_contract_type','合同分类','QTHT','其他合同',7,5,'2',null,'其他合同');
insert into t_dictionary values('120000008','dic_contract_type','合同分类','QTLX','其他类型',8,8,'3',null,'其他类型');
insert into t_dictionary values('120000009','dic_contract_type','合同分类','FBHT','分包合同',9,9,'4',null,'分包合同');

/*-----------------模块分类-dic_module_type-------------------------*/
delete from t_dictionary where Groupname="dic_module_type";
insert into t_dictionary values('130000001','dic_module_type','模块分类','JJGC','基建',1,1,'1',null,'基建工程');
insert into t_dictionary values('130000002','dic_module_type','模块分类','NWGC','农网',2,2,'2',null,'农网工程');
insert into t_dictionary values('130000003','dic_module_type','模块分类','YXGC','营销',3,3,'3',null,'营销工程');
insert into t_dictionary values('130000004','dic_module_type','模块分类','JGGC','技改',4,4,'4',null,'技改工程');
insert into t_dictionary values('130000005','dic_module_type','模块分类','WJGC','外接',5,5,'5',null,'外接工程');
insert into t_dictionary values('130000006','dic_module_type','模块分类','GSHT','公司',6,6,'6',null,'公司合同');

/*-----------------归档状态-dic_archive_state-------------------------*/
delete from t_dictionary where Groupname="dic_archive_state";
insert into t_dictionary values('140000001','dic_archive_state','归档状态','yet','已归档',1,1,'1',null,'已归档');
insert into t_dictionary values('140000002','dic_archive_state','归档状态','no','未归档',2,2,'2',null,'未归档');

/*-----------------资金类型-dic_fund_type-------------------------*/
delete from t_dictionary where Groupname="dic_fund_type";
insert into t_dictionary values('150000001','dic_fund_type','资金类型','receipt','收款',1,1,'1',null,'收款');
insert into t_dictionary values('150000002','dic_fund_type','资金类型','pay','付款',2,2,'2',null,'付款');

/*-----------------是否启用-dic_state-------------------------*/
delete from t_dictionary where Groupname="dic_state";
insert into t_dictionary values('160000001','dic_state','是否启用','invalid','停用',0,0,'0',null,'停用');
insert into t_dictionary values('160000002','dic_state','是否启用','valid','启用',1,1,'1',null,'启用');

/*-----------------客户类型-dic_customer_type-------------------------*/
delete from t_dictionary where Groupname="dic_customer_type";
insert into t_dictionary values('170000001','dic_customer_type','客户类型','zgs','总公司',1,1,'1',null,'总公司');
insert into t_dictionary values('170000002','dic_customer_type','客户类型','fgs','分公司',2,2,'2',null,'分公司');
insert into t_dictionary values('170000003','dic_customer_type','客户类型','nbdw','内部单位',3,3,'3',null,'内部单位');
insert into t_dictionary values('170000004','dic_customer_type','客户类型','wbdw','外部单位',4,4,'4',null,'外部单位');
insert into t_dictionary values('170000005','dic_customer_type','客户类型','fbs','合格分包商',5,5,'5',null,'总公司');

/*-------------------分页常量dic_page_size-----------------------------------------*/
delete from t_dictionary where Groupname="dic_page_size";
insert into t_dictionary values('180000001','dic_page_size','分页常量','small','小',5,5,'5',null,'小');
insert into t_dictionary values('180000002','dic_page_size','分页常量','middle','中',10,10,'10',null,'中');
insert into t_dictionary values('180000003','dic_page_size','分页常量','big','大',15,15,'15',null,'大');

/*-------------------资金计划执行状态dic_fund_state-----------------------------------------*/
delete from t_dictionary where Groupname="dic_fund_state";
insert into t_dictionary values('190000001','dic_fund_state','资金计划执行状态','plan','计划',1,1,'1',null,'计划');
insert into t_dictionary values('190000002','dic_fund_state','资金计划执行状态','execute','执行',2,2,'2',null,'执行');

/*-------------------预留资金支出项dic_reserve_item-----------------------------------------*/
delete from t_dictionary where Groupname="dic_reserve_item";
insert into t_dictionary values('210000001','dic_reserve_item','预留资金支出项','ycReserve','宜昌公司预留',1,1,'1',null,'宜昌公司预留');
insert into t_dictionary values('210000002','dic_reserve_item','预留资金支出项','ssbbReserve','三送本部预留',2,2,'2',null,'三送本部预留');
insert into t_dictionary values('210000003','dic_reserve_item','预留资金支出项','otherFee','其他费用',3,3,'3',null,'其他费用');
insert into t_dictionary values('210000004','dic_reserve_item','预留资金支出项','baseReserve','基本预留',4,4,'4',null,'基本预留');
insert into t_dictionary values('210000005','dic_reserve_item','预留资金支出项','jjbbReserve','基建部预留',5,5,'5',null,'基建部预留');
insert into t_dictionary values('210000006','dic_reserve_item','预留资金支出项','ownerReserve','业主项目部预留',6,6,'6',null,'业主项目部预留');

/*-------------------工程类型dic_line_type-----------------------------------------*/
delete from t_dictionary where Groupname="dic_line_type";
insert into t_dictionary values('220000001','dic_line_type','工程类型','blank','未分类',1,1,'1',null,'未分类');
insert into t_dictionary values('220000002','dic_line_type','工程类型','electric','电气类',2,2,'2',null,'电气类');
insert into t_dictionary values('220000003','dic_line_type','工程类型','civil','土建类',3,3,'3',null,'土建类');

/*-------------------发票类型dic_bill_type-----------------------------------------*/
delete from t_dictionary where Groupname="dic_bill_type";
insert into t_dictionary values('230000001','dic_bill_type','发票类型','ja','建安',1,1,'1',null,'建安发票');
insert into t_dictionary values('230000002','dic_bill_type','发票类型','fw','服务',2,2,'2',null,'服务业发票');
insert into t_dictionary values('230000003','dic_bill_type','发票类型','zp','专票',3,3,'3',null,'专用发票');
insert into t_dictionary values('230000004','dic_bill_type','发票类型','zb','增补',4,4,'4',null,'增补发票');
insert into t_dictionary values('230000005','dic_bill_type','发票类型','pt','普通',5,5,'5',null,'普通发票');














