CREATE TABLE `USER` (
    `id` varchar(40) NOT NULL DEFAULT '' COMMENT '用户id',
    `mobile` varchar(13) NOT NULL COMMENT '手机号',
    `account` varchar(13) NOT NULL COMMENT '帐号',
    `school` varchar(20) NOT NULL COMMENT '学校',
    `name` varchar(10) NOT NULL DEFAULT '' COMMENT '姓名',
    `password` varchar(16) NOT NULL COMMENT '密码',
    `status` varchar(32) NOT NULL DEFAULT 'NORMAL' COMMENT '用户状态: NORNAL 正常 LOCKED 被锁定',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime DEFAULT NULL COMMENT '修改时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='用户表';

CREATE TABLE `USER_EXT` (
    `user_id` varchar(40) NOT NULL DEFAULT '' COMMENT '用户id',
    `sex` varchar(32) NOT NULL COMMENT '性别: MALE:男 FEMALE:女',
    `nickname` varchar(20) NOT NULL DEFAULT '' COMMENT '昵称',
    `sign` varchar(30) NOT NULL DEFAULT '' COMMENT '签名',
    `area` int(11) DEFAULT NULL COMMENT '地区',
    `avatar` varchar(255) DEFAULT '' COMMENT '用户头像',
    `birthday` datetime DEFAULT NULL COMMENT '生日',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime DEFAULT NULL COMMENT '修改时间',
    PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='用户扩展信息表';


CREATE TABLE `TEACHER` (
    `id` varchar(40) NOT NULL DEFAULT '' COMMENT 'id',
    `sex` varchar(32) NOT NULL COMMENT '性别: MALE:男 FEMALE:女',
    `name` varchar(10) NOT NULL DEFAULT '' COMMENT '姓名',
    `avatar` varchar(255) DEFAULT '' COMMENT '用户头像',
    `title` varchar(100) DEFAULT '' COMMENT '头衔',
    `description` varchar(200) DEFAULT '' COMMENT '简介',
    `content` text DEFAULT '' COMMENT '内容',
    `weight` int(11) NOT NULL DEFAULT 0 COMMENT '权重',
    `type` varchar(32) NOT NULL DEFAULT 0 COMMENT '类型: EXPERT 授课专家 TUTOR 导师 RESEARCHER 研究人员',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime DEFAULT NULL COMMENT '修改时间',
    PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='老师表';

CREATE TABLE `COURSE` (
    `id` varchar(40) NOT NULL DEFAULT '' COMMENT 'id',
    `cover` varchar(255) DEFAULT '' COMMENT '封面',
    `title` varchar(100) DEFAULT '' COMMENT '标题',
    `description` varchar(200) DEFAULT '' COMMENT '简介',
    `content` text DEFAULT '' COMMENT '内容',
    `weight` int(11) NOT NULL DEFAULT 0 COMMENT '权重',
    `year` int(11) NOT NULL COMMENT '年份',
    `type` varchar(32) NOT NULL DEFAULT 0 COMMENT '类型: LECTURE 讲座 VISIT 参观 OUTDOORS 户外',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime DEFAULT NULL COMMENT '修改时间',
    PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT COMMENT='课程培训表';

CREATE TABLE `ADMIN` (
    `id` varchar(40) NOT NULL COMMENT '管理员id',
    `account` varchar(32) NOT NULL DEFAULT '' COMMENT '登录账号',
    `name` varchar(13) NOT NULL DEFAULT '' COMMENT '用户姓名',
    `mobile` varchar(13) DEFAULT NULL COMMENT '电话号码',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime DEFAULT NULL COMMENT '修改时间',
    `password` varchar(32) NOT NULL DEFAULT '' COMMENT '用户密码',
    `nickname` varchar(13) DEFAULT NULL COMMENT '昵称',
    `flag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '用户标识：0 已删除，1 正常 2 被锁定',
    `description` varchar(250) DEFAULT NULL COMMENT '描述',
    `avatar` varchar(250) DEFAULT NULL COMMENT '头像',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='管理员信息表';

CREATE TABLE `CITY` (
    `id` int(10) NOT NULL,
    `city_name` varchar(50) NOT NULL,
    `province_id` varchar(20) NOT NULL,
    `first_letter` varchar(20) DEFAULT NULL,
    `is_hot` int(10) NOT NULL DEFAULT '0',
    `state` int(10) NOT NULL DEFAULT '1',
    PRIMARY KEY (`city_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='城市表';

CREATE TABLE `PROVINCE` (
    `province_id` varchar(20) NOT NULL,
    `province_name` varchar(50) NOT NULL,
    PRIMARY KEY (`province_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='省份表';
