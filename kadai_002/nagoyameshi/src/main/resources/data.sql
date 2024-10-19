-- categorysテーブル
INSERT IGNORE INTO categorys (id, name) VALUES (1, '居酒屋');
INSERT IGNORE INTO categorys (id, name) VALUES (2, '焼肉');
INSERT IGNORE INTO categorys (id, name) VALUES (4, '定食');
INSERT IGNORE INTO categorys (id, name) VALUES (5, 'カレー');
INSERT IGNORE INTO categorys (id, name) VALUES (6, '喫茶店');
INSERT IGNORE INTO categorys (id, name) VALUES (7, '中華料理');
INSERT IGNORE INTO categorys (id, name) VALUES (8, 'イタリア料理');
INSERT IGNORE INTO categorys (id, name) VALUES (9, 'フランス料理');
INSERT IGNORE INTO categorys (id, name) VALUES (10, 'スペイン料理');
INSERT IGNORE INTO categorys (id, name) VALUES (11, '韓国料理');
INSERT IGNORE INTO categorys (id, name) VALUES (12, 'タイ料理');
INSERT IGNORE INTO categorys (id, name) VALUES (13, '海鮮料理');
INSERT IGNORE INTO categorys (id, name) VALUES (14, 'ステーキ');
INSERT IGNORE INTO categorys (id, name) VALUES (15, 'ハンバーグ');
INSERT IGNORE INTO categorys (id, name) VALUES (16, 'ハンバーガー');
INSERT IGNORE INTO categorys (id, name) VALUES (17, 'そば');
INSERT IGNORE INTO categorys (id, name) VALUES (18, 'お好み焼き');
INSERT IGNORE INTO categorys (id, name) VALUES (19, 'たこ焼き');
INSERT IGNORE INTO categorys (id, name) VALUES (20, '鍋料理');
INSERT IGNORE INTO categorys (id, name) VALUES (21, 'バー');
INSERT IGNORE INTO categorys (id, name) VALUES (22, 'パン');
INSERT IGNORE INTO categorys (id, name) VALUES (23, 'スイーツ');
INSERT IGNORE INTO categorys (id, name) VALUES (24, '焼き鳥');
INSERT IGNORE INTO categorys (id, name) VALUES (25, 'すき焼き');
INSERT IGNORE INTO categorys (id, name) VALUES (26, 'しゃぶしゃぶ');
INSERT IGNORE INTO categorys (id, name) VALUES (27, '天ぷら');
INSERT IGNORE INTO categorys (id, name) VALUES (28, '鉄板焼き');
INSERT IGNORE INTO categorys (id, name) VALUES (29, '和食');
INSERT IGNORE INTO categorys (id, name) VALUES (30, 'うどん');
INSERT IGNORE INTO categorys (id, name) VALUES (31, '丼物');
INSERT IGNORE INTO categorys (id, name) VALUES (32, 'ラーメン');
INSERT IGNORE INTO categorys (id, name) VALUES (33, 'おでん');
INSERT IGNORE INTO categorys (id, name) VALUES (34, '揚げ物');

-- storesテーブル
INSERT IGNORE INTO stores (id, category_id, name, image_name, description, price_floor, price_cap, opening_time, closing_time, seating_capacity, postal_code, address, phone_number, regular_holiday) VALUES (1,34,'気晴亭','store01.jpg','エビフライも「名古屋めし」の代表的なメニューの1つです。',2000,5000,'11:00','21:00', 88, '460-0012','愛知県名古屋市中区千代田5-21-6','052-251-4741','火');
INSERT IGNORE INTO stores (id, category_id, name, image_name, description, price_floor, price_cap, opening_time, closing_time, seating_capacity, postal_code, address, phone_number, regular_holiday) VALUES (2,30,'やをよし','store02.jpg','今や蒲郡を代表するグルメとなったガマゴリうどんですが、その誕生は2012年と比較的最近です。',1000,3000,'11:00','20:30', 99, '443-0031','愛知県蒲郡市竹島町7-12','0533-68-3804','月');
INSERT IGNORE INTO stores (id, category_id, name, image_name, description, price_floor, price_cap, opening_time, closing_time, seating_capacity, postal_code, address, phone_number, regular_holiday) VALUES (3,29,'手打ちきしめん 芳の家','store03.jpg','名古屋めしと言えばコレ！という方も多い「きしめん」。幅が広く薄い麺が特徴の名古屋の名物料理となっています。',800,4000,'11:30','20:30', 100, '466-0044','愛知県名古屋市昭和区桜山町2-38','052-841-6884','月');
INSERT IGNORE INTO stores (id, category_id, name, image_name, description, price_floor, price_cap, opening_time, closing_time, seating_capacity, postal_code, address, phone_number, regular_holiday) VALUES (4,20,'どて焼五條','store04.jpg','先述したみそかつの起源にもかかわるどて煮は、豆味噌のダシで牛や豚のモツ（内臓）を煮込んだもの。',1000,3000,'17:00','22:00', 120, '451-0042','愛知県名古屋市西区那古野1-37-28','052-565-0739','日');
INSERT IGNORE INTO stores (id, category_id, name, image_name, description, price_floor, price_cap, opening_time, closing_time, seating_capacity, postal_code, address, phone_number, regular_holiday) VALUES (5,17,'福本屋','store05.jpg','「へきなん焼きそば」は、2011年に当時の碧南市議会議員が碧南市をアピールする新名物として考案したご当地グルメです。',1500,5000,'12:00','0:00', 60, '447-0877','愛知県碧南市栄町1-32','0566-41-2441','火');
INSERT IGNORE INTO stores (id, category_id, name, image_name, description, price_floor, price_cap, opening_time, closing_time, seating_capacity, postal_code, address, phone_number, regular_holiday) VALUES (6,4,'さくとん','store06.jpg','みそかつ（味噌カツ）は、豆味噌ベースのみそだれをかけたトンカツです。',1000,2000,'11:00','22:00', 80, '466-0044','愛知県名古屋市昭和区桜山町5-98-7','052-852-0657','日');
INSERT IGNORE INTO stores (id, category_id, name, image_name, description, price_floor, price_cap, opening_time, closing_time, seating_capacity, postal_code, address, phone_number, regular_holiday) VALUES (7,30,'大正庵釜春 本店','store07.jpg','ご当地グルメ大国愛知県には、ユニークな名物料理がたくさんあり、岡崎の「もろこしうどん」もそのひとつです。',1200,5000,'11:00','21:00', 50, '444-0921','愛知県岡崎市中岡崎町6-9','0564-21-0517','水');
INSERT IGNORE INTO stores (id, category_id, name, image_name, description, price_floor, price_cap, opening_time, closing_time, seating_capacity, postal_code, address, phone_number, regular_holiday) VALUES (8,5,'お宿 和陽館','store08.jpg','稲沢市で2023年に生まれたばかりの新たなご当地グルメ、稲沢カレー。',1000,2000,'6:00','18:00', 45, '492-8142','愛知県稲沢市長野2-10-8','0587-23-5565','金');
INSERT IGNORE INTO stores (id, category_id, name, image_name, description, price_floor, price_cap, opening_time, closing_time, seating_capacity, postal_code, address, phone_number, regular_holiday) VALUES (9,5,'オレンジカウンティ上地店','store09.jpg','「岡崎に来たら、まずカレーパン！」という合言葉があるほど、岡崎カレーパンは岡崎観光に欠かせません。',1800,5000,'10:00','14:30', 66, '444-0823','愛知県岡崎市上地3-7-10','0564-53-8271','水');
INSERT IGNORE INTO stores (id, category_id, name, image_name, description, price_floor, price_cap, opening_time, closing_time, seating_capacity, postal_code, address, phone_number, regular_holiday) VALUES (10,34,'結屋','store10.jpg','全国の自治体で「犬」が名称につくのは犬山市だけということもあり、「犬（ドッグ）」と、パンに食材を挟んで食べる「ドッグ」を掛け合わせて生まれました。',1000,4000,'10:00','17:00', 78, '484-0081','愛知県犬山市大字犬山字東古券679','0568-61-1921','月');
INSERT IGNORE INTO stores (id, category_id, name, image_name, description, price_floor, price_cap, opening_time, closing_time, seating_capacity, postal_code, address, phone_number, regular_holiday) VALUES (11,16,'燻 kemuru','store11.jpg','「幸田角煮バーガー」は幸田町商工会と幸田町役場産業振興課が連携し、新地域ブランドとして生まれたハンバーガーです。',1500,2000,'11:00','17:00', 110, '444-0124','愛知県額田郡幸田町大字深溝字稲葉山12','0564-62-5039','火');
INSERT IGNORE INTO stores (id, category_id, name, image_name, description, price_floor, price_cap, opening_time, closing_time, seating_capacity, postal_code, address, phone_number, regular_holiday) VALUES (12,29,'魚松 とりめし','store12.jpg','愛知県高浜市で親しまれている「高浜とりめし」とは、意外にも歴史の長いご当地グルメです。',1000,2000,'9:00','17:00', 68, '444-1331','愛知県高浜市屋敷町7-7-1','0566-53-0416','火');
INSERT IGNORE INTO stores (id, category_id, name, image_name, description, price_floor, price_cap, opening_time, closing_time, seating_capacity, postal_code, address, phone_number, regular_holiday) VALUES (13,34,'手羽先 むつみ','store13.jpg','手羽先唐揚げは、鶏の手羽先を唐揚げにしてタレを塗り、塩、胡椒、白ごまなどを振りかけて食べる料理です。',1800,5000,'17:00','0:00', 50, '460-0008','愛知県名古屋市中区栄3-8-125','052-684-5577','月');
INSERT IGNORE INTO stores (id, category_id, name, image_name, description, price_floor, price_cap, opening_time, closing_time, seating_capacity, postal_code, address, phone_number, regular_holiday) VALUES (14,34,'カフェ&レストラン 田園','store14.jpg','愛知にゆかりの深い戦国武将・織田信長が清洲城を天下取りの出発点にしたことから、天下「取り」と「鶏」のからあげを掛け合わせて考案されました。',800,3000,'7:00','21:00', 70, '452-0908','愛知県清須市寺野郷前57','052-409-0031','火');
INSERT IGNORE INTO stores (id, category_id, name, image_name, description, price_floor, price_cap, opening_time, closing_time, seating_capacity, postal_code, address, phone_number, regular_holiday) VALUES (15,32,'味仙 今池本店','store15.jpg','台湾ラーメンは、豚ひき肉、ニラ、長ねぎ、もやしなどの具材を炒めてトウガラシで味付けし、醤油ベースのスープとあわせて茹で麺にかけた、名古屋発祥の麺料理です。',1000,4000,'17:30','0:00', 80, '464-0850','愛知県名古屋市千種区今池1-12-10','052-733-7670','木');
INSERT IGNORE INTO stores (id, category_id, name, image_name, description, price_floor, price_cap, opening_time, closing_time, seating_capacity, postal_code, address, phone_number, regular_holiday) VALUES (16,18,'キッチンはせ家','store16.jpg','鉄板ナポリタンは、「鉄板スパゲティ」や「鉄板イタリアン」とも呼ばれる「名古屋めし」の1つです。',1200,2000,'11:00','14:30', 30, '461-0001','愛知県名古屋市東区泉1-21−1','052-971-3192','土');
INSERT IGNORE INTO stores (id, category_id, name, image_name, description, price_floor, price_cap, opening_time, closing_time, seating_capacity, postal_code, address, phone_number, regular_holiday) VALUES (17,30,'勢川 本店','store17.jpg','「豊橋カレーうどん」は地域おこしの一環として、豊橋観光コンベンション協会を中心にして生まれました。',1500,4000,'11:00','19:30', 40, '440-0897','愛知県豊橋市松葉町3-88','0532-54-0614','月');
INSERT IGNORE INTO stores (id, category_id, name, image_name, description, price_floor, price_cap, opening_time, closing_time, seating_capacity, postal_code, address, phone_number, regular_holiday) VALUES (18,30,'味噌にこみ たから','store18.jpg','味噌煮込みうどんは、八丁味噌仕立ての汁にうどんを入れて煮込んだ、愛知を代表する麺料理の一つです。',1200,3000,'11:30','19:00', 55, '460-0011','愛知県名古屋市中区大須2-16-17','052-231-5523','木');

-- rolesテーブル
INSERT IGNORE INTO roles (id, name) VALUES (1, 'ROLE_FREE_MEMBER');
INSERT IGNORE INTO roles (id, name) VALUES (2, 'ROLE_PAID_MEMBER');
INSERT IGNORE INTO roles (id, name) VALUES (3, 'ROLE_ADMIN');

-- usersテーブル
INSERT IGNORE INTO users (id, role_id, name, furigana, postal_code, address, phone_number, age, occupation, email, password, enabled ) VALUES (1, 1, '侍 太郎', 'サムライ タロウ', '101-0022', '東京都千代田区神田練塀町300番地', '090-1234-5678', '2000年3月2日', '学生', 'taro.samurai@example.com', '$2a$10$2JNjTwZBwo7fprL2X4sv.OEKqxnVtsVQvuXDkI8xVGix.U3W5B7CO', true);
INSERT IGNORE INTO users (id, role_id, name, furigana, postal_code, address, phone_number, age, occupation, email, password, enabled ) VALUES (2, 3, '侍 花子', 'サムライ ハナコ', '101-0022', '東京都千代田区神田練塀町300番地', '090-1234-5678', '2005年8月12日', '学生', 'hanako.samurai@example.com', '$2a$10$2JNjTwZBwo7fprL2X4sv.OEKqxnVtsVQvuXDkI8xVGix.U3W5B7CO', true);
INSERT IGNORE INTO users (id, role_id, name, furigana, postal_code, address, phone_number, age, occupation, email, password, enabled ) VALUES (3, 1, '侍 義勝', 'サムライ ヨシカツ', '638-0644', '奈良県五條市西吉野町湯川X-XX-XX', '090-1234-5678', '1989年6月3日', '会社員', 'yoshikatsu.samurai@example.com', 'password', false);
INSERT IGNORE INTO users (id, role_id, name, furigana, postal_code, address, phone_number, age, occupation, email, password, enabled ) VALUES (4, 1, '侍 幸美', 'サムライ サチミ', '342-0006', '埼玉県吉川市南広島X-XX-XX', '090-1234-5678', '1976年10月5日', '会社員', 'sachimi.samurai@example.com', 'password', false);
INSERT IGNORE INTO users (id, role_id, name, furigana, postal_code, address, phone_number, age, occupation, email, password, enabled ) VALUES (5, 2, '侍 雅', 'サムライ ミヤビ', '527-0209', '滋賀県東近江市佐目町X-XX-XX', '090-1234-5678', '1994年1月2日', '会社員', 'miyabi.samurai@example.com', '$2a$10$2JNjTwZBwo7fprL2X4sv.OEKqxnVtsVQvuXDkI8xVGix.U3W5B7CO', true);
INSERT IGNORE INTO users (id, role_id, name, furigana, postal_code, address, phone_number, age, occupation, email, password, enabled ) VALUES (6, 1, '侍 正保', 'サムライ マサヤス', '989-1203', '宮城県柴田郡大河原町旭町X-XX-XX', '090-1234-5678', '1998年4月19日', '会社員', 'masayasu.samurai@example.com', 'password', false);
INSERT IGNORE INTO users (id, role_id, name, furigana, postal_code, address, phone_number, age, occupation, email, password, enabled ) VALUES (7, 2, '侍 真由美', 'サムライ マユミ', '951-8015', '新潟県新潟市松岡町X-XX-XX', '090-1234-5678', '2002年7月2日', '会社員', 'mayumi.samurai@example.com', 'password', false);
INSERT IGNORE INTO users (id, role_id, name, furigana, postal_code, address, phone_number, age, occupation, email, password, enabled ) VALUES (8, 1, '侍 安民', 'サムライ ヤスタミ', '241-0033', '神奈川県横浜市旭区今川町X-XX-XX', '090-1234-5678', '1996年12月1日', '会社員', 'yasutami.samurai@example.com', 'password', false);
INSERT IGNORE INTO users (id, role_id, name, furigana, postal_code, address, phone_number, age, occupation, email, password, enabled ) VALUES (9, 1, '侍 章緒', 'サムライ アキオ', '739-2103', '広島県東広島市高屋町宮領X-XX-XX', '090-1234-5678', '1970年11月30日', '無職', 'akio.samurai@example.com', 'password', false);
INSERT IGNORE INTO users (id, role_id, name, furigana, postal_code, address, phone_number, age, occupation, email, password, enabled ) VALUES (10, 1, '侍 祐子', 'サムライ ユウコ', '601-0761', '京都府南丹市美山町高野X-XX-XX', '090-1234-5678', '1998年2月9日', '会社員', 'yuko.samurai@example.com', 'password', false);
INSERT IGNORE INTO users (id, role_id, name, furigana, postal_code, address, phone_number, age, occupation, email, password, enabled ) VALUES (11, 1, '侍 秋美', 'サムライ アキミ', '606-8235', '京都府京都市左京区田中西春菜町X-XX-XX', '090-1234-5678', '1985年3月29日', '会社員', 'akimi.samurai@example.com', 'password', false);
INSERT IGNORE INTO users (id, role_id, name, furigana, postal_code, address, phone_number, age, occupation, email, password, enabled ) VALUES (12, 1, '侍 信平', 'サムライ シンペイ', '673-1324', '兵庫県加東市新定X-XX-XX', '090-1234-5678', '2001年12月31日', '無職', 'shinpei.samurai@example.com', 'password', false);

-- reservationsテーブル
INSERT IGNORE INTO reservations (id, user_id, store_id, reservation_datetime, count) VALUES (1, 1, 1, '2023-04-01 09:30:00', 2);
INSERT IGNORE INTO reservations (id, user_id, store_id, reservation_datetime, count) VALUES (2, 1, 2, '2023-04-01 14:30:00', 3);
INSERT IGNORE INTO reservations (id, user_id, store_id, reservation_datetime, count) VALUES (3, 1, 3, '2023-04-01 15:30:00', 4);
INSERT IGNORE INTO reservations (id, user_id, store_id, reservation_datetime, count) VALUES (4, 1, 4, '2023-04-01 08:30:00', 5);
INSERT IGNORE INTO reservations (id, user_id, store_id, reservation_datetime, count) VALUES (5, 1, 5, '2023-04-01 17:30', 6);
INSERT IGNORE INTO reservations (id, user_id, store_id, reservation_datetime, count) VALUES (6, 1, 6, '2023-04-01 12:30', 2);
INSERT IGNORE INTO reservations (id, user_id, store_id, reservation_datetime, count) VALUES (7, 1, 7, '2023-04-01 12:30', 3);
INSERT IGNORE INTO reservations (id, user_id, store_id, reservation_datetime, count) VALUES (8, 1, 8, '2023-04-01 12:30', 4);
INSERT IGNORE INTO reservations (id, user_id, store_id, reservation_datetime, count) VALUES (9, 1, 9, '2023-04-01 12:30', 5);
INSERT IGNORE INTO reservations (id, user_id, store_id, reservation_datetime, count) VALUES (10, 1, 10, '2023-04-01 07:30', 6);
INSERT IGNORE INTO reservations (id, user_id, store_id, reservation_datetime, count) VALUES (11, 1, 11, '2023-04-01 07:30', 4);
INSERT IGNORE INTO reservations (id, user_id, store_id, reservation_datetime, count) VALUES (12, 1, 12, '2023-04-01 07:30', 2);
INSERT IGNORE INTO reservations (id, user_id, store_id, reservation_datetime, count) VALUES (13, 1, 13, '2023-04-01 07:30', 6);
INSERT IGNORE INTO reservations (id, user_id, store_id, reservation_datetime, count) VALUES (14, 1, 14, '2023-04-01 07:30', 5);
INSERT IGNORE INTO reservations (id, user_id, store_id, reservation_datetime, count) VALUES (15, 1, 15, '2023-04-01 07:30', 6);

-- reviewsテーブル
INSERT IGNORE INTO reviews (id, store_id, user_id, star, review) VALUES (1, 1, 1, 3, '名古屋では有名な格安で焼肉食べ放題のお店。タイミングよく仕事で行く機会があったので、地元の友人と一緒に来店しました。店内は広くゆったりとできます。');
INSERT IGNORE INTO reviews (id, store_id, user_id, star, review) VALUES (2, 1, 2, 4, 'タイミングよく仕事で行く機会があったので、地元の友人と一緒に来店しました。店内は広くゆったりとできます。');
INSERT IGNORE INTO reviews (id, store_id, user_id, star, review) VALUES (3, 1, 3, 5, '地元の友人と一緒に来店しました。店内は広くゆったりとできます。');
INSERT IGNORE INTO reviews (id, store_id, user_id, star, review) VALUES (4, 1, 4, 3, '良かったです');
INSERT IGNORE INTO reviews (id, store_id, user_id, star, review) VALUES (5, 1, 5, 3, '良かったです');
INSERT IGNORE INTO reviews (id, store_id, user_id, star, review) VALUES (6, 1, 6, 2, '微妙でした');
INSERT IGNORE INTO reviews (id, store_id, user_id, star, review) VALUES (7, 1, 7, 5, 'すごく良かったです');
INSERT IGNORE INTO reviews (id, store_id, user_id, star, review) VALUES (8, 1, 8, 5, 'すごく良かったです');
INSERT IGNORE INTO reviews (id, store_id, user_id, star, review) VALUES (9, 1, 9, 2, '微妙でした');
INSERT IGNORE INTO reviews (id, store_id, user_id, star, review) VALUES (10, 1, 10, 5, 'すごく良かったです');
INSERT IGNORE INTO reviews (id, store_id, user_id, star, review) VALUES (11, 1, 11, 3, '良かったです');
INSERT IGNORE INTO reviews (id, store_id, user_id, star, review) VALUES (12, 1, 12, 4, 'すごく良かったです');
INSERT IGNORE INTO reviews (id, store_id, user_id, star, review) VALUES (13, 1, 13, 1, '微妙でした');
INSERT IGNORE INTO reviews (id, store_id, user_id, star, review) VALUES (14, 1, 14, 5, 'すごく良かったです');
INSERT IGNORE INTO reviews (id, store_id, user_id, star, review) VALUES (15, 1, 15, 2, '微妙でした');
INSERT IGNORE INTO reviews (id, store_id, user_id, star, review) VALUES (16, 1, 16, 4, 'すごく良かったです');
INSERT IGNORE INTO reviews (id, store_id, user_id, star, review) VALUES (17, 1, 17, 4, 'すごく良かったです');
INSERT IGNORE INTO reviews (id, store_id, user_id, star, review) VALUES (18, 1, 18, 5, 'すごく良かったです');
INSERT IGNORE INTO reviews (id, store_id, user_id, star, review) VALUES (19, 1, 19, 4, 'すごく良かったです');
INSERT IGNORE INTO reviews (id, store_id, user_id, star, review) VALUES (20, 1, 20, 5, 'すごく良かったです');

-- favoritesテーブル
INSERT IGNORE INTO favorites (id, store_id, user_id) VALUES (1, 1, 5);
INSERT IGNORE INTO favorites (id, store_id, user_id) VALUES (2, 2, 5);
INSERT IGNORE INTO favorites (id, store_id, user_id) VALUES (3, 3, 5);

-- companiesテーブル
INSERT IGNORE INTO companies (id, name, postal_code, address, representative, establishment_date, capital, business, number_of_employees) VALUES
(1, 'NAGOYAMESHI株式会社', '1010022', '東京都千代田区神田練塀町300番地 住友不動産秋葉原駅前ビル5F', '侍 太郎', '2015年3月19日', '110,000千円', '飲食店等の情報提供サービス', '83名');




