/*
 Navicat Premium Data Transfer

 Source Server         : Test
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : news

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 04/07/2020 11:49:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` int(11) NOT NULL,
  `cname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类别名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, '娱乐');
INSERT INTO `category` VALUES (2, '生活');
INSERT INTO `category` VALUES (3, '财经');
INSERT INTO `category` VALUES (4, '科技');
INSERT INTO `category` VALUES (5, '军事');

-- ----------------------------
-- Table structure for collection
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NULL DEFAULT NULL,
  `nid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  INDEX `nid`(`nid`) USING BTREE,
  CONSTRAINT `collection_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `collection_ibfk_2` FOREIGN KEY (`nid`) REFERENCES `news` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of collection
-- ----------------------------
INSERT INTO `collection` VALUES (5, 46, 49);
INSERT INTO `collection` VALUES (9, 49, 49);
INSERT INTO `collection` VALUES (10, 49, 24);

-- ----------------------------
-- Table structure for comments
-- ----------------------------
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nid` int(11) NULL DEFAULT NULL,
  `uid` int(11) NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `commentstime` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  INDEX `nid`(`nid`) USING BTREE,
  CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `comments_ibfk_2` FOREIGN KEY (`nid`) REFERENCES `news` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comments
-- ----------------------------
INSERT INTO `comments` VALUES (3, 49, 2, '程序员的一次失误，在 45 分钟里搞垮了一家上市公司', '2020-06-26 11:23:00');
INSERT INTO `comments` VALUES (5, 49, 45, 'Test', '2020-05-06 11:11:11');
INSERT INTO `comments` VALUES (6, 49, 46, 'lyt到此一游', '2020-07-02 21:06:19');
INSERT INTO `comments` VALUES (7, 23, 46, 'test', '2020-07-03 17:31:45');
INSERT INTO `comments` VALUES (8, 23, 46, '测试评论', '2020-07-03 17:31:53');
INSERT INTO `comments` VALUES (9, 23, 46, '测试分页', '2020-07-03 17:31:59');
INSERT INTO `comments` VALUES (10, 23, 46, '还没到', '2020-07-03 17:32:04');
INSERT INTO `comments` VALUES (11, 23, 46, '123', '2020-07-03 17:34:19');
INSERT INTO `comments` VALUES (12, 23, 46, '123123', '2020-07-03 17:34:21');
INSERT INTO `comments` VALUES (14, 49, 49, 'lye8到此一游', '2020-07-04 10:57:31');
INSERT INTO `comments` VALUES (15, 49, 49, 'lye8到此一游', '2020-07-04 10:57:40');
INSERT INTO `comments` VALUES (16, 49, 49, 'lye8到此一游', '2020-07-04 10:57:40');
INSERT INTO `comments` VALUES (17, 49, 49, 'lye8到此一游', '2020-07-04 10:57:40');

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news`  (
  `id` int(11) NOT NULL,
  `cid` int(11) NULL DEFAULT NULL,
  `newsname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '博客名',
  `looknum` int(11) NULL DEFAULT NULL,
  `replynum` int(11) NULL DEFAULT NULL,
  `time` datetime(0) NULL DEFAULT NULL,
  `photoaddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `textaddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `cid`(`cid`) USING BTREE,
  CONSTRAINT `news_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES (1, 1, '黄磊：我当年收情书都是按麻袋算；黄晓明：赵薇礼物都是用卡车装的 ', 500, 26, '2020-06-26 13:28:00', 'D:\\news\\newPhoto\\001.png', 'D:\\news\\newText\\001.txt');
INSERT INTO `news` VALUES (2, 1, '姐姐们公演造型比拼，黄圣依穿成一朵花，张雨绮绿衣，万茜厉害了 ', 206, 10, '2020-06-26 12:20:00', 'D:\\news\\newPhoto\\002.png', 'D:\\news\\newText\\002.txt');
INSERT INTO `news` VALUES (3, 1, '4位“红得快，凉得更快”的艺人：第四位太可惜了，当年你都追过谁呢？ ', 563, 25, '2020-06-26 11:52:00', 'D:\\news\\newPhoto\\003.png', 'D:\\news\\newText\\003.txt');
INSERT INTO `news` VALUES (4, 1, '43岁知名男星官宣当爸，妻子孕肚照超美，粉丝关注点却在丈夫身上 ', 285, 65, '2020-06-26 11:21:00', 'D:\\news\\newPhoto\\004.png', 'D:\\news\\newText\\004.txt');
INSERT INTO `news` VALUES (5, 1, '端午晚会3个槽点：女主持人紧张，男嘉宾不修边幅！', 582, 55, '2020-06-26 11:29:00', 'D:\\news\\newPhoto\\005.png', 'D:\\news\\newText\\005.txt');
INSERT INTO `news` VALUES (6, 1, '陈乔恩给男友开视频，开口第一句的“称呼”亮了，太甜了 ', 450, 456, '2020-06-26 12:13:00', 'D:\\news\\newPhoto\\006.png', 'D:\\news\\newText\\006.txt');
INSERT INTO `news` VALUES (7, 1, '38年后《少林寺》演员今昔照：李连杰已老，丁岚变化大，计春华去世 ', 700, 54, '2020-06-26 11:41:00', 'D:\\news\\newPhoto\\007.png', 'D:\\news\\newText\\007.txt');
INSERT INTO `news` VALUES (8, 1, '杨丞琳和李荣浩的双向爱恋也太甜了吧！女方：因为是你送的，今天就把它穿上 ', 451, 22, '2020-06-26 10:46:00', 'D:\\news\\newPhoto\\008.png', 'D:\\news\\newText\\008.txt');
INSERT INTO `news` VALUES (9, 1, '火箭少女101解散，其他人都没动，为何杨超越急着改认证？ ', 453, 75, '2020-06-26 11:22:00', 'D:\\news\\newPhoto\\009.png', 'D:\\news\\newText\\009.txt');
INSERT INTO `news` VALUES (10, 1, '《乘风破浪的姐姐》镜头数量计算？宁静最多，倒数第一仅四个镜头 ', 320, 44, '2020-06-26 11:23:00', 'D:\\news\\newPhoto\\010.png', 'D:\\news\\newText\\010.txt');
INSERT INTO `news` VALUES (11, 2, '宵夜榜单第一名！在家15分钟搞定，广东人最爱这一口', 431, 29, '2020-05-25 14:41:34', 'D:\\news\\newPhoto\\011.png', 'D:\\news\\newText\\011.txt');
INSERT INTO `news` VALUES (12, 2, '卤蛋的家常做法，加1瓶啤酒，鲜香入味，口感紧实，比茶叶蛋好吃', 276, 65, '2020-06-26 11:40:11', 'D:\\news\\newPhoto\\012.png', 'D:\\news\\newText\\012.txt');
INSERT INTO `news` VALUES (13, 2, '长沙、常德、湘潭、湘西…谁才是湖南米粉江湖中的大佬？', 763, 46, '2020-06-24 22:21:42', 'D:\\news\\newPhoto\\013.png', 'D:\\news\\newText\\013.txt');
INSERT INTO `news` VALUES (14, 2, '腊肉和它是天生一对，把它们炒一起，又香又下饭，连吃3天都不腻', 721, 96, '2020-04-02 11:49:51', 'D:\\news\\newPhoto\\014.png', 'D:\\news\\newText\\014.txt');
INSERT INTO `news` VALUES (15, 2, '食物放冰箱保存时间久，但这几种食材不能放冰箱，看完涨知识了', 432, 71, '2020-06-21 20:15:59', 'D:\\news\\newPhoto\\015.png', 'D:\\news\\newText\\015.txt');
INSERT INTO `news` VALUES (16, 2, '最近迷上了葱油面，除了好吃之外，操作也很简单', 639, 48, '2020-04-02 11:12:14', 'D:\\news\\newPhoto\\016.png', 'D:\\news\\newText\\016.txt');
INSERT INTO `news` VALUES (17, 2, '教你做老济南炒合菜，营养美味，好吃解馋，8块钱成本做一大盘', 366, 79, '2020-04-29 11:55:27', 'D:\\news\\newPhoto\\017.png', 'D:\\news\\newText\\017.txt');
INSERT INTO `news` VALUES (18, 2, '15道容易上手的特色家常菜，在家就能做大厨，收藏学起来', 499, 81, '2020-06-25 18:46:33', 'D:\\news\\newPhoto\\018.png', 'D:\\news\\newText\\018.txt');
INSERT INTO `news` VALUES (19, 2, '夏天，豆腐和丝瓜一起煮，不放鸡精也很鲜，清甜爽口、特别的家常', 411, 83, '2020-05-26 10:57:32', 'D:\\news\\newPhoto\\019.png', 'D:\\news\\newText\\019.txt');
INSERT INTO `news` VALUES (20, 2, '调肉馅时，不能少了这3种“料”，否则馅又干又柴，还不香', 321, 101, '2020-05-06 22:00:54', 'D:\\news\\newPhoto\\020.png', 'D:\\news\\newText\\020.txt');
INSERT INTO `news` VALUES (21, 3, '2020年存款新规来了，银行存10万元，每年可拿一月工资利息', 439, 736, '2020-06-26 14:31:09', 'D:\\news\\newPhoto\\021.png', 'D:\\news\\newText\\021.txt');
INSERT INTO `news` VALUES (22, 3, '世界大萧条就要来了，中国人，你该如何规避风险？', 419, 99, '2020-06-26 13:57:28', 'D:\\news\\newPhoto\\022.png', 'D:\\news\\newText\\022.txt');
INSERT INTO `news` VALUES (23, 3, '坐地起价？中国果断取消千亿订单！德国媒体：中国太疯狂', 463, 61, '2020-06-26 13:58:53', 'D:\\news\\newPhoto\\023.png', 'D:\\news\\newText\\023.txt');
INSERT INTO `news` VALUES (24, 3, '特朗普真是“小天才”！在他的呼吁下，多家美企加大对中国的投资', 559, 78, '2020-06-26 15:38:37', 'D:\\news\\newPhoto\\024.png', 'D:\\news\\newText\\024.txt');
INSERT INTO `news` VALUES (25, 3, '谁才是”中国第一鸭“？它去年净赚8个亿，门店数是周黑鸭的8倍', 799, 43, '2020-04-28 11:59:32', 'D:\\news\\newPhoto\\025.png', 'D:\\news\\newText\\025.txt');
INSERT INTO `news` VALUES (26, 3, '中国股市：为什么富人越炒越富，穷人越炒越穷？如果有10万资金，牢记犹太人“卖铜”思维，难怪这么赚钱', 444, 56, '2020-04-05 22:49:44', 'D:\\news\\newPhoto\\026.png', 'D:\\news\\newText\\026.txt');
INSERT INTO `news` VALUES (27, 3, '未来十年，中国将出现三家世界级芯片企业', 796, 56, '2020-06-26 08:46:47', 'D:\\news\\newPhoto\\027.png', 'D:\\news\\newText\\027.txt');
INSERT INTO `news` VALUES (28, 3, '最新！5月70城房价出炉：这些城市房价又涨了', 658, 42, '2020-06-23 10:32:29', 'D:\\news\\newPhoto\\028.png', 'D:\\news\\newText\\028.txt');
INSERT INTO `news` VALUES (29, 3, '都说合肥在赌，殊不知南昌赌得更大', 755, 369, '2020-06-26 12:32:30', 'D:\\news\\newPhoto\\029.png', 'D:\\news\\newText\\029.txt');
INSERT INTO `news` VALUES (30, 3, '犹太人赚钱的思维是多么可怕：如果不想穷下去，死记“五个数字”：10、20、50、60、721', 623, 74, '2020-04-13 13:28:30', 'D:\\news\\newPhoto\\030.png', 'D:\\news\\newText\\030.txt');
INSERT INTO `news` VALUES (31, 4, '程序员的一次失误，在 45 分钟里搞垮了一家上市公司', 746, 69, '2020-03-31 23:27:42', 'D:\\news\\newPhoto\\031.png', 'D:\\news\\newText\\031.txt');
INSERT INTO `news` VALUES (32, 4, '是时候跟Eclipse说再见了...', 759, 43, '2020-04-14 18:50:42', 'D:\\news\\newPhoto\\032.png', 'D:\\news\\newText\\032.txt');
INSERT INTO `news` VALUES (33, 4, '买了辆新车，却连朋友圈都不敢发一条', 749, 33, '2020-05-15 11:31:57', 'D:\\news\\newPhoto\\033.png', 'D:\\news\\newText\\033.txt');
INSERT INTO `news` VALUES (34, 4, '偷偷降低4G网速？工信部出手，要求三大运营商全面自查', 648, 76, '2020-06-25 21:00:50', 'D:\\news\\newPhoto\\034.png', 'D:\\news\\newText\\034.txt');
INSERT INTO `news` VALUES (35, 4, '华为智慧屏为什么不叫电视？瞅瞅这些功能是否真的颠覆了电视行业', 456, 72, '2020-06-24 15:46:09', 'D:\\news\\newPhoto\\035.png', 'D:\\news\\newText\\035.txt');
INSERT INTO `news` VALUES (36, 4, '日本打破世界最快超级计算机速度记录', 483, 47, '2020-06-24 16:36:24', 'D:\\news\\newPhoto\\036.png', 'D:\\news\\newText\\036.txt');
INSERT INTO `news` VALUES (37, 4, '写ios和安卓系统的人到底有多牛？', 459, 85, '2020-04-08 14:34:09', 'D:\\news\\newPhoto\\037.png', 'D:\\news\\newText\\037.txt');
INSERT INTO `news` VALUES (38, 4, '不要网上乱拷贝代码了！一段网上找的代码突然炸了！', 853, 69, '2020-04-19 12:32:52', 'D:\\news\\newPhoto\\038.png', 'D:\\news\\newText\\038.txt');
INSERT INTO `news` VALUES (39, 4, '腾讯、百度、阿里巴巴，这些名字是怎么来的？背后的故事太精彩', 777, 98, '2020-04-03 10:36:10', 'D:\\news\\newPhoto\\039.png', 'D:\\news\\newText\\039.txt');
INSERT INTO `news` VALUES (40, 4, '失败的代价：在世界上真实发生过的5个“昂贵”的失败科技项目', 666, 83, '2020-06-26 10:03:43', 'D:\\news\\newPhoto\\040.png', 'D:\\news\\newText\\040.txt');
INSERT INTO `news` VALUES (41, 5, '美EP-3E电子侦察机又在台湾西南空域出现，经过巴士海峡向南海方向飞行', 417, 96, '2020-06-26 12:14:00', 'D:\\news\\newPhoto\\041.png', 'D:\\news\\newText\\041.txt');
INSERT INTO `news` VALUES (42, 5, '世界请看清楚，印度正从中印双边协议上后退', 69, 56, '2020-06-22 20:53:37', 'D:\\news\\newPhoto\\042.png', 'D:\\news\\newText\\042.txt');
INSERT INTO `news` VALUES (43, 5, '真正目的已经达到？四处挑衅后，高票挤进安理会', 846, 34, '2020-06-20 23:14:03', 'D:\\news\\newPhoto\\043.png', 'D:\\news\\newText\\043.txt');
INSERT INTO `news` VALUES (44, 5, 'B-52到底有多大？把它P到核动力航母上比就明白了', 847, 74, '2020-04-16 18:27:28', 'D:\\news\\newPhoto\\044.png', 'D:\\news\\newText\\044.txt');
INSERT INTO `news` VALUES (45, 5, '世界十大现役狙击步枪！', 741, 69, '2020-04-04 12:06:50', 'D:\\news\\newPhoto\\045.png', 'D:\\news\\newText\\045.txt');
INSERT INTO `news` VALUES (46, 5, '世界上失败的十大军事发明', 864, 91, '2020-04-06 17:15:40', 'D:\\news\\newPhoto\\046.png', 'D:\\news\\newText\\046.txt');
INSERT INTO `news` VALUES (47, 5, '坦克舱室温度能高达56度，为何价值千万的坦克连个空调都不给装？', 763, 64, '2020-05-15 16:14:28', 'D:\\news\\newPhoto\\047.png', 'D:\\news\\newText\\047.txt');
INSERT INTO `news` VALUES (48, 5, '056型护卫舰有多大？当它出现在辽宁舰和054A面前时就明白了', 739, 52, '2020-04-16 21:10:07', 'D:\\news\\newPhoto\\048.png', 'D:\\news\\newText\\048.txt');
INSERT INTO `news` VALUES (49, 5, '不丹“断水”，印度媒体慌了', 656, 100, '2020-06-26 16:09:45', 'D:\\news\\newPhoto\\049.png', 'D:\\news\\newText\\049.txt');
INSERT INTO `news` VALUES (50, 5, '给钱就卖，俄罗斯将在最短时间内向印度交付数十架战斗机', 563, 47, '2020-06-21 12:54:38', 'D:\\news\\newPhoto\\050.png', 'D:\\news\\newText\\050.txt');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  `photo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 50 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (2, 'tom', '123', 0, 'D:\\news\\headPhoto\\tom7\\tom7.jpg', NULL);
INSERT INTO `user` VALUES (5, 'test', '123', 0, 'null', '111');
INSERT INTO `user` VALUES (43, '222', '123', 0, 'null', '123@163.com');
INSERT INTO `user` VALUES (44, 'tom6', '123', 1, 'null', 'mryitonglin@163.com');
INSERT INTO `user` VALUES (45, 'tom777', '202cb962ac59075b964b07152d234b70', 1, 'D:\\news\\headPhoto\\45\\tom77720200630221822799.jpg', 'mryitonglin@163.com');
INSERT INTO `user` VALUES (46, 'lyt', '202cb962ac59075b964b07152d234b70', 1, 'D:\\news\\headPhoto\\46\\lyt20200702210440234.jpg', 'mryitonglin@163.com');
INSERT INTO `user` VALUES (47, 'lyt3', '202cb962ac59075b964b07152d234b70', 0, 'null', 'mryitonglin@163.com');
INSERT INTO `user` VALUES (49, 'lyt8', '250cf8b51c773f3f8dc8b4be867a9a02', 1, 'D:\\news\\headPhoto\\49\\lyt820200704110141886.jpg', 'mryitonglin@163.com');

SET FOREIGN_KEY_CHECKS = 1;
