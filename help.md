##################建表语句#####################################################

-- 日志表
CREATE TABLE `sys_log` (
  `id` bigint(40) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ip` varchar(20) NOT NULL DEFAULT '' COMMENT '操作地址的IP',
  `create_by` datetime DEFAULT NULL COMMENT '操作时间',
  `remark` varchar(255) NOT NULL DEFAULT '' COMMENT '操作内容',
  `operate_url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '操作的访问地址',
  `operate_by` varchar(90) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '操作的浏览器',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2154 DEFAULT CHARSET=utf8

-- 浏览记录表
CREATE TABLE `sys_view` (
  `id` bigint(40) NOT NULL AUTO_INCREMENT,
  `ip` varchar(20) NOT NULL COMMENT '访问IP',
  `create_by` datetime DEFAULT NULL COMMENT '访问时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2353 DEFAULT CHARSET=utf8;

-- 文章分类表
CREATE TABLE `tbl_article_category` (
  `id` bigint(40) NOT NULL AUTO_INCREMENT,
  `category_id` bigint(40) NOT NULL COMMENT '分类id',
  `article_id` bigint(40) NOT NULL COMMENT '文章id',
  `create_by` datetime NOT NULL COMMENT '创建时间',
  `modified_by` datetime NOT NULL COMMENT '更新时间',
  `is_effective` tinyint(1) DEFAULT '1' COMMENT '表示当前数据是否有效，默认为1有效，0则无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

INSERT INTO `tbl_article_category` (`id`, `category_id`, `article_id`, `create_by`, `modified_by`, `is_effective`) VALUES ('3', '16', '5', '2019-03-28 14:55:39', '2019-03-28 14:55:39', '1');
INSERT INTO `tbl_article_category` (`id`, `category_id`, `article_id`, `create_by`, `modified_by`, `is_effective`) VALUES ('5', '17', '8', '2019-03-28 15:15:49', '2019-03-28 15:15:49', '1');


-- 文章内容表
CREATE TABLE `tbl_article_content` (
  `id` bigint(40) NOT NULL AUTO_INCREMENT,
  `content` text NOT NULL,
  `article_id` bigint(40) NOT NULL COMMENT '对应文章ID',
  `create_by` datetime NOT NULL COMMENT '创建时间',
  `modifield_by` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

INSERT INTO `tbl_article_content` (`id`, `content`, `article_id`, `create_by`, `modifield_by`) VALUES ('3', '世界最亲密的关系，莫不是亲情，什么都会改变，但是唯有血缘是不会改变的！！！', '5', '2019-03-28 14:55:39', '2019-03-28 14:55:39');
INSERT INTO `tbl_article_content` (`id`, `content`, `article_id`, `create_by`, `modifield_by`) VALUES ('5', '这世间最美的事情莫过于爱情，曾经有一份真挚的爱情在我身边，我没有珍惜，知道失去我才追悔莫及，如果上天能让我在来一次的机会，我想对她说，嘿嘿！！！！', '8', '2019-03-28 15:15:49', '2019-03-28 15:15:49');


-- 博文信息表
CREATE TABLE `tbl_article_info` (
  `id` bigint(40) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(50) NOT NULL DEFAULT '' COMMENT '文章标题',
  `summary` varchar(300) NOT NULL DEFAULT '' COMMENT '文章简介，默认100个汉字以内',
  `is_top` tinyint(1) NOT NULL DEFAULT '0' COMMENT '文章是否置顶，0为否，1为是',
  `traffic` int(10) NOT NULL DEFAULT '0' COMMENT '文章访问量',
  `create_by` datetime NOT NULL COMMENT '创建时间',
  `modified_by` datetime NOT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
INSERT INTO `tbl_article_info` (`id`, `title`, `summary`, `is_top`, `traffic`, `create_by`, `modified_by`) VALUES ('5', '亲爱的兄妹', '亲爱的兄妹', '0', '2', '2019-03-28 14:55:39', '2019-03-28 14:55:39');
INSERT INTO `tbl_article_info` (`id`, `title`, `summary`, `is_top`, `traffic`, `create_by`, `modified_by`) VALUES ('8', '爱情', '爱情的魔力转圈圈', '0', '19', '2019-03-28 15:15:48', '2019-03-28 15:15:48');


-- 没什么用
CREATE TABLE `tbl_article_message` (
  `id` bigint(40) NOT NULL AUTO_INCREMENT,
  `article_id` bigint(40) NOT NULL COMMENT '文章ID',
  `message_id` bigint(40) NOT NULL COMMENT '对应的留言ID',
  `create_by` datetime NOT NULL COMMENT '创建时间',
  `is_effective` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否有效，默认为1有效，置0无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 题图表
CREATE TABLE `tbl_article_picture` (
  `id` bigint(40) NOT NULL AUTO_INCREMENT,
  `article_id` bigint(40) NOT NULL COMMENT '对应文章id',
  `picture_url` varchar(100) NOT NULL DEFAULT '' COMMENT '图片url',
  `create_by` datetime NOT NULL COMMENT '创建时间',
  `modified_by` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='这张表用来保存题图url，每一篇文章都应该有题图';

-- 博文分类表
CREATE TABLE `tbl_category_info` (
  `id` bigint(40) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL COMMENT '分类名称',
  `number` tinyint(10) NOT NULL DEFAULT '0' COMMENT '该分类下的文章数量',
  `create_by` datetime NOT NULL COMMENT '分类创建时间',
  `modified_by` datetime NOT NULL COMMENT '分类修改时间',
  `is_effective` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否有效，默认为1有效，为0无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

INSERT INTO `tbl_category_info` (`id`, `name`, `number`, `create_by`, `modified_by`, `is_effective`) VALUES ('16', '亲情', '1', '2019-03-28 14:53:19', '2019-03-28 14:53:19', '1');
INSERT INTO `tbl_category_info` (`id`, `name`, `number`, `create_by`, `modified_by`, `is_effective`) VALUES ('17', '爱情', '2', '2019-03-28 14:59:58', '2019-03-28 14:59:58', '1');


-- 文章评论表
CREATE TABLE `tbl_comment` (
  `id` bigint(40) NOT NULL AUTO_INCREMENT,
  `article_id` bigint(40) NOT NULL COMMENT '文章ID',
  `ip` varchar(20) NOT NULL COMMENT 'ip',
  `name` varchar(40) NOT NULL COMMENT '名称',
  `content` varchar(300) NOT NULL COMMENT '内容',
  `create_by` datetime NOT NULL COMMENT '创建时间',
  `is_effective` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否有效，默认为1有效，置0无效',
  `email` varchar(40) NOT NULL COMMENT '名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

########################################结束###############################################

#######################热部署开始####################################################
springboot项目配置热部署功能:
只需要添加devtools依赖即可:
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<optional>true</optional>
			<scope>true</scope>
		</dependency>
VM会定时扫描重新加载且仅加载有改动的类文件（.class文件），而不是加载所有的类文件，大大减少了类加载耗费的时间，从而实现热部署的功能。
Eclipse默认自动编译，而idea默认手动编译，因此idea需要修改两个参数以达到任意时间自动编译的目的。
首先，File->setting->搜索compiler->将Build project automatically打勾（注意后面only works not running/debugging，所以我们要实现热部署就必须打破这个限制，于是乎有了下面设置）
然后，CTRL+ALT+SHIFT+/ 组合键打开 Maintenance窗口选择Registry... ,找到compiler.automake.allow.when.app.running选项，打勾开启运行时编译功能
###################################热部署结束################################

图床网址：
https://imgchr.com/

- 搭建参考：https://blog.csdn.net/u012702547/article/details/53740047（springboot搭建）
- springboot实现拦截器和过滤器：http://www.cnblogs.com/paddix/p/8365558.html
- RESTful API 设计：还没有实现，有机会在弄