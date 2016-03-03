
use htgl;

/*-----------------权限表基础数据-------------------------*/
delete from t_auth;
INSERT INTO `t_auth` VALUES ('1001', '系统管理', '0', 1001, '1');
INSERT INTO `t_auth` VALUES ('1010', '用户管理', '1001', 1010, '1');
INSERT INTO `t_auth` VALUES ('1011', '用户新增', '1010', 1011, '1');
INSERT INTO `t_auth` VALUES ('1012', '用户角色修改', '1010', 1012, '1');
INSERT INTO `t_auth` VALUES ('1013', '用户删除', '1010', 1013, '1');
INSERT INTO `t_auth` VALUES ('1020', '角色管理', '1001', 1020, '1');
INSERT INTO `t_auth` VALUES ('1021', '角色新增', '1020', 1021, '1');
INSERT INTO `t_auth` VALUES ('1022', '角色修改', '1020', 1022, '1');
INSERT INTO `t_auth` VALUES ('1023', '角色删除', '1020', 1023, '1');
INSERT INTO `t_auth` VALUES ('1024', '角色详细', '1020', 1024, '1');
INSERT INTO `t_auth` VALUES ('1030', '客户管理', '1001', 1030, '1');
INSERT INTO `t_auth` VALUES ('1031', '客户新增', '1030', 1031, '1');
INSERT INTO `t_auth` VALUES ('1032', '客户修改', '1030', 1032, '1');
INSERT INTO `t_auth` VALUES ('1033', '客户删除', '1030', 1033, '1');
INSERT INTO `t_auth` VALUES ('1040', '基础数据管理', '1001', 1040, '1');
INSERT INTO `t_auth` VALUES ('1041', '总包导入', '1040', 1041, '1');
INSERT INTO `t_auth` VALUES ('1042', '分包导入', '1040', 1042, '1');
INSERT INTO `t_auth` VALUES ('1043', '计划资金导入', '1040', 1043, '1');
INSERT INTO `t_auth` VALUES ('1044', '执行资金导入', '1040', 1044, '1');
INSERT INTO `t_auth` VALUES ('1045', '结算资金导入', '1040', 1045, '1');
INSERT INTO `t_auth` VALUES ('2001', '合同管理', '0', 2001, '1');
INSERT INTO `t_auth` VALUES ('2002', '合同录入', '2001', 2002, '1');
INSERT INTO `t_auth` VALUES ('2003', '合同流水', '2001', 2003, '1');
INSERT INTO `t_auth` VALUES ('2004', '合同归档', '2001', 2004, '1');
INSERT INTO `t_auth` VALUES ('2005', '合同查找', '2001', 2005, '1');
INSERT INTO `t_auth` VALUES ('2006', '合同会签', '2001', 2006, '1');
INSERT INTO `t_auth` VALUES ('2011', '合同修改', '2002', 2011, '1');
INSERT INTO `t_auth` VALUES ('2012', '合同删除', '2002', 2012, '1');
INSERT INTO `t_auth` VALUES ('2013', '合同详细', '2002', 2013, '1');
INSERT INTO `t_auth` VALUES ('2014', '合同列表', '2002', 2005, '1');
INSERT INTO `t_auth` VALUES ('2021', '归档修改', '2004', 2021, '1');
INSERT INTO `t_auth` VALUES ('2022', '归档详细', '2004', 2022, '1');
INSERT INTO `t_auth` VALUES ('2023', '归档列表', '2004', 2004, '1');
INSERT INTO `t_auth` VALUES ('2031', '会签修改', '2006', 2031, '1');
INSERT INTO `t_auth` VALUES ('2032', '打印会签表', '2006', 2032, '1');
INSERT INTO `t_auth` VALUES ('2033', '会签列表', '2006', 2006, '1');
INSERT INTO `t_auth` VALUES ('3001', '资金管理', '0', 3001, '1');
INSERT INTO `t_auth` VALUES ('3002', '切块管理', '3001', 3002, '1');
INSERT INTO `t_auth` VALUES ('3003', '资金计划管理', '3001', 3003, '1');
INSERT INTO `t_auth` VALUES ('3004', '资金执行管理', '3001', 3004, '1');
INSERT INTO `t_auth` VALUES ('3005', '项目结算管理', '3001', 3005, '1');
INSERT INTO `t_auth` VALUES ('3006', '收付款综合查询', '3001', 3006, '1');
INSERT INTO `t_auth` VALUES ('3011', '切块编辑', '3002', 3011, '1');
INSERT INTO `t_auth` VALUES ('3012', '切块删除', '3002', 3012, '1');
INSERT INTO `t_auth` VALUES ('3013', '切块详细', '3002', 3013, '1');
INSERT INTO `t_auth` VALUES ('3014', '切块列表', '3002', 3002, '1');
INSERT INTO `t_auth` VALUES ('3021', '资金计划编辑', '3003', 3021, '1');
INSERT INTO `t_auth` VALUES ('3022', '资金计划删除', '3003', 3022, '1');
INSERT INTO `t_auth` VALUES ('3023', '资金计划列表', '3003', 3003, '1');
INSERT INTO `t_auth` VALUES ('3031', '资金执行编辑', '3004', 3031, '1');
INSERT INTO `t_auth` VALUES ('3032', '资金执行删除', '3004', 3032, '1');
INSERT INTO `t_auth` VALUES ('3033', '资金执行列表', '3004', 3004, '1');
INSERT INTO `t_auth` VALUES ('3041', '资金结算编辑', '3005', 3041, '1');
INSERT INTO `t_auth` VALUES ('3042', '资金结算删除', '3005', 3042, '1');
INSERT INTO `t_auth` VALUES ('3043', '资金结算列表', '3005', 3005, '1');
INSERT INTO `t_auth` VALUES ('4001', '汇总统计', '0', 4001, '1');
INSERT INTO `t_auth` VALUES ('5001', '个人中心', '0', 5001, '1');
INSERT INTO `t_auth` VALUES ('5011', '修改密码', '5001', 5011, '1');
INSERT INTO `t_auth` VALUES ('5012', '修改个人信息', '5001', 5012, '1');




/*--------------------角色表基础数据--------------------------------------*/
delete from t_role;
INSERT INTO `t_role` (`role_Id`, `roleName`) VALUES ('1', '系统管理员');
INSERT INTO `t_role` (`role_Id`, `roleName`) VALUES	('2', '合同录入员');
INSERT INTO `t_role` (`role_Id`, `roleName`) VALUES	('3', '财务人员');
INSERT INTO `t_role` (`role_Id`, `roleName`) VALUES	('4', '办公室主任');
INSERT INTO `t_role` (`role_Id`, `roleName`) VALUES	('5', '项目切块人员');
INSERT INTO `t_role` (`role_Id`, `roleName`) VALUES	('6', '领导');

/*---------------------角色权限--------------------------------------------------*/
delete from t_role_auth;
INSERT INTO `t_role_auth` VALUES ('1400831326218240', '1', '1010');
INSERT INTO `t_role_auth` VALUES ('1400831326218633', '1', '1001');
INSERT INTO `t_role_auth` VALUES ('1400831326219016', '1', '1012');
INSERT INTO `t_role_auth` VALUES ('1400831326219191', '1', '1021');
INSERT INTO `t_role_auth` VALUES ('1400831326219233', '1', '1011');
INSERT INTO `t_role_auth` VALUES ('1400831326219444', '1', '1013');
INSERT INTO `t_role_auth` VALUES ('1400831326219594', '1', '1020');
INSERT INTO `t_role_auth` VALUES ('1400831326220071', '1', '1030');
INSERT INTO `t_role_auth` VALUES ('1400831326220110', '1', '1022');
INSERT INTO `t_role_auth` VALUES ('1400831326220264', '1', '1023');
INSERT INTO `t_role_auth` VALUES ('1400831326220890', '1', '1024');
INSERT INTO `t_role_auth` VALUES ('1400831326221181', '1', '1031');
INSERT INTO `t_role_auth` VALUES ('1400831326221412', '1', '2001');
INSERT INTO `t_role_auth` VALUES ('1400831326221903', '1', '1032');
INSERT INTO `t_role_auth` VALUES ('1400831326221956', '1', '1033');
INSERT INTO `t_role_auth` VALUES ('1400831326222752', '1', '2002');
INSERT INTO `t_role_auth` VALUES ('1400831326223257', '1', '2004');
INSERT INTO `t_role_auth` VALUES ('1400831326223271', '1', '2006');
INSERT INTO `t_role_auth` VALUES ('1400831326223437', '1', '2005');
INSERT INTO `t_role_auth` VALUES ('1400831326223936', '1', '2003');
INSERT INTO `t_role_auth` VALUES ('1400831326224646', '1', '2012');
INSERT INTO `t_role_auth` VALUES ('1400831326224833', '1', '2011');
INSERT INTO `t_role_auth` VALUES ('1400831326225022', '1', '2013');
INSERT INTO `t_role_auth` VALUES ('1400831326225234', '1', '2021');
INSERT INTO `t_role_auth` VALUES ('1400831326225344', '1', '2031');
INSERT INTO `t_role_auth` VALUES ('1400831326225911', '1', '2022');
INSERT INTO `t_role_auth` VALUES ('1400831326226044', '1', '3001');
INSERT INTO `t_role_auth` VALUES ('1400831326226614', '1', '2032');
INSERT INTO `t_role_auth` VALUES ('1400831326226953', '1', '3002');
INSERT INTO `t_role_auth` VALUES ('1400831326226965', '1', '3003');
INSERT INTO `t_role_auth` VALUES ('1400831326227058', '1', '3006');
INSERT INTO `t_role_auth` VALUES ('1400831326227118', '1', '3011');
INSERT INTO `t_role_auth` VALUES ('1400831326227516', '1', '3005');
INSERT INTO `t_role_auth` VALUES ('1400831326227703', '1', '3004');
INSERT INTO `t_role_auth` VALUES ('1400831326228336', '1', '3021');
INSERT INTO `t_role_auth` VALUES ('1400831326228358', '1', '3022');
INSERT INTO `t_role_auth` VALUES ('1400831326228707', '1', '3012');
INSERT INTO `t_role_auth` VALUES ('1400831326228809', '1', '3013');
INSERT INTO `t_role_auth` VALUES ('1400831326229039', '1', '3042');
INSERT INTO `t_role_auth` VALUES ('1400831326229164', '1', '3031');
INSERT INTO `t_role_auth` VALUES ('1400831326229315', '1', '3041');
INSERT INTO `t_role_auth` VALUES ('1400831326229432', '1', '3032');
INSERT INTO `t_role_auth` VALUES ('1400831326230951', '1', '4001');

/*---------------------用户表----------------------------------------*/
delete from t_user;
INSERT INTO `t_user` VALUES ('1', 'admin', '21232F297A57A5A743894A0E4A801FC3', 'admin', '15586374695', '1');

/*----------------------用户角色------------------------------------------*/
delete from t_user_role;
INSERT INTO `t_user_role` VALUES ('1', '1', '1');

/*--------------------- 合同编号简码--------------------------------------*/
delete from t_code;
INSERT INTO `t_code` VALUES ('1', 'SS-JJZB', '基建总包合同', '1', '1', '1');
INSERT INTO `t_code` VALUES ('10', 'SS-YXZB', '营销总包', '3', '1', '2');
INSERT INTO `t_code` VALUES ('11', 'SS-YXF', '营销分包', '3', '9', '1');
INSERT INTO `t_code` VALUES ('12', 'SS-JGZB', '技改总包', '4', '1', '1');
INSERT INTO `t_code` VALUES ('13', 'SS-JGF', '技改分包', '4', '9', '1');
INSERT INTO `t_code` VALUES ('14', 'SS-WJZB', '外接总包', '5', '1', '1');
INSERT INTO `t_code` VALUES ('15', 'SS-WJF', '外接分包', '5', '9', '1');
INSERT INTO `t_code` VALUES ('2', 'SS-JF', '基建分包', '1', '2', '1');
INSERT INTO `t_code` VALUES ('3', 'SS-JR', '基建任务书', '1', '3', '1');
INSERT INTO `t_code` VALUES ('4', 'SS-TS', '特殊合同', '1', '6', '1');
INSERT INTO `t_code` VALUES ('5', 'SS-QT', '其他合同', '1', '7', '1');
INSERT INTO `t_code` VALUES ('6', 'SS-NZ', '内招分包', '1', '4', '2');
INSERT INTO `t_code` VALUES ('7', 'SS-LW', '劳务合同', '1', '5', '1');
INSERT INTO `t_code` VALUES ('8', 'SS-NWZB', '农网总包', '2', '1', '2');
INSERT INTO `t_code` VALUES ('9', 'SS-NWF', '农网分包', '2', '9', '2');

