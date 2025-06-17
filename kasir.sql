-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.30 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             12.1.0.6537
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for kasir
CREATE DATABASE IF NOT EXISTS `kasir` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `kasir`;

-- Dumping structure for table kasir.product
CREATE TABLE IF NOT EXISTS `product` (
  `id_product` int NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `stock` int NOT NULL,
  PRIMARY KEY (`id_product`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table kasir.product: ~50 rows (approximately)
INSERT INTO `product` (`id_product`, `description`, `image`, `name`, `price`, `stock`) VALUES
	(1, 'Minuman ringan berkarbonasi rasa cola', '1750136416943_coca-cola.jpeg', 'Coca-Cola 330ml', 8000, 45),
	(2, 'Air mineral dalam kemasan botol', '1750136436096_Aqua (Product) - Wisnuhandy Widyoastono.jpeg', 'Aqua Botol 600ml', 4000, 95),
	(3, 'Mie instan rasa ayam bawang', '1750136450855_Indomie Rasa Ayam Special Chicken Flavor Instant Noodles 2_65 oz.jpeg', 'Indomie Ayam Bawang', 3000, 120),
	(4, 'Rokok kretek filter', '1750136473071_Smoking.jpeg', 'Sampoerna Mild', 25000, 80),
	(5, 'Permen coklat dengan kacang', '1750136503159_SILVER QUEEN CASHEW NUT 55 GR.jpeg', 'Silverqueen 33gr', 10000, 60),
	(6, 'Sabun mandi batang', '1750136527793_New Lifebuoy Red Germ Killing Better Skin Protecting care Sri Lanka Natural 100g _ eBay.jpeg', 'Lifebuoy Merah', 5000, 40),
	(7, 'Kopi sachet 3in1', '1750136549644_Kopiko Cappuccino Candy.jpeg', 'Kopiko 3in1', 1500, 200),
	(8, 'Biskuit sandwich dengan krim vanilla', '1750136567848_biskuit.jpeg', 'Roma Kelapa', 8000, 75),
	(9, 'Minyak goreng kemasan 1 liter', '1750136583562_BIMOLI 1 L.jpeg', 'Bimoli 1 Liter', 18000, 30),
	(10, 'Kecap manis botol', '1750136596995_ABC KECAP MANIS POUCH 520ML - Rp20_500.jpeg', 'Kecap ABC 275ml', 12000, 45),
	(11, 'Sarden kaleng dengan saus tomat', '1750136611545_SARDINES ABC SAUS EXTRA PEDAS 425 GR.jpeg', 'Sarden ABC 425gr', 15000, 25),
	(12, 'Shampoo anti ketombe', '1750136627621_Shampoo Clear Men Ice Cool Menthol.jpeg', 'Clear Men 90ml', 15000, 35),
	(13, 'Pasta gigi rasa mint', '1750136643632_download (4).jpeg', 'Pepsodent 190gr', 10000, 40),
	(14, 'Gula pasir kemasan 1kg', '1750136659967_GULAKU 1 kg.jpeg', 'Gulaku 1kg', 15000, 20),
	(15, 'Teh celup kantong', '1750136696325_Teh celup sosro.jpeg', 'Teh Celup Sosro', 5000, 150),
	(16, 'Snack keripik kentang rasa original', '1750136714587_Snack - Lays rasa rumput laut.jpeg', 'Lays Rumput Laut', 10000, 60),
	(17, 'Susu kental manis kaleng', '1750136732090_download (5).jpeg', 'Frisian Flag 370gr', 12000, 30),
	(18, 'Telur ayam ras', '1750136757324_Telur Ayam Negeri.jpeg', 'Telur Ayam 1kg', 25000, 15),
	(19, 'Detergen bubuk untuk mesin cuci', '1750136774186_Rinso Matic Professional 1_68L.jpeg', 'Rinso Matic 800gr', 18000, 25),
	(20, 'Minyak kayu putih botol', '1750136785685_CAP LANG MINYAK KAYU PUTIH 120 ML.jpeg', 'Cap Kapak 60ml', 10000, 40),
	(21, 'Minuman soda rasa jeruk', '1750136825852_FANTA PET 1 L.jpeg', 'Fanta 330ml', 7000, 45),
	(22, 'Minuman soda rasa anggur', '1750136847335_download (6).jpeg', 'Sprite 330ml', 7000, 40),
	(23, 'Minuman isotonik', '1750136860648_download (7).jpeg', 'Pocari Sweat 500ml', 10000, 35),
	(24, 'Susu UHT coklat kotak', '1750136887096_kote.jpeg', 'Ultra Milk Coklat 250ml', 6000, 50),
	(25, 'Minuman jahe instan', '1750136899063_download (8).jpeg', 'Tolak Angin Sachet', 3000, 80),
	(26, 'Keripik singkong pedas', '1750136913578_Snack Chitato 35g Grilled Beef.jpeg', 'Chitato 75gr', 10000, 60),
	(27, 'Biskuit coklat', '1750136939461_Redirect Notice.jpeg', 'Oreo 133gr', 12000, 40),
	(28, 'Permen karet rasa buah', '1750136954426_BIG BABOL STRAWBERRY STICK 24 GR - PERMEN.jpeg', 'Chewing Gum', 2000, 120),
	(29, 'Wafer coklat', '1750136989541_TANGO WAFER CHOCOLATE 39 GR.jpeg', 'Tango Wafer', 5000, 70),
	(30, 'Kacang atom pedas', '1750137014525_Sukro Kacang Atom Original ll Sukro Kacang berselaput.jpeg', 'Kacang Atom 50gr', 8000, 45),
	(31, 'Beras premium', '1750137092325_Rice flour_rosebrand.jpeg', 'Beras Setan 5kg', 70000, 15),
	(32, 'Mie telur kemasan', '1750137111859_download (9).jpeg', 'Mie Sedaap', 2500, 100),
	(33, 'Tepung terigu serbaguna', '1750137134067_BOGASARI TERIGU SEGITIGA BIRU 1 KG - TEPUNG.jpeg', 'Tepung Bogasari 1kg', 12000, 25),
	(34, 'Garam beryodium', '1750137147221_garam kapal berat 250 g.jpeg', 'Garam Cap Kapal 250gr', 5000, 30),
	(35, 'Mentega tawar', '1750137165066_MENTEGA BLUE BAND MASTER 1 KG.jpeg', 'Blue Band 250gr', 15000, 20),
	(36, 'Pewangi pakaian', '1750137179696_ad907912-fcb3-42e7-81e6-d6fdd973f9a4.jpeg', 'So Soft 100ml', 12000, 30),
	(37, 'Pembalut wanita', '1750137210429_CHARM SAFE NIGHT GATHER 35CM 16\'S.jpeg', 'Charm Safe Night', 15000, 40),
	(38, 'Tisu basah antiseptik', '1750137231840_Dettol Tisu basah 10s beli 2 gratis 1.jpeg', 'Wet Tissue 30 sheets', 8000, 50),
	(39, 'Korek api gas', '1750137244894_KOREK API GAS YUKIT_YUKITO_KOREK PEMATIK API_ECER.jpeg', 'Korek Api Gas', 5000, 60),
	(40, 'Plastik sampah hitam', '1750137256710_HD Plastic Trash Bag 60x100cm.jpeg', 'Plastik Sampah 30x40', 10000, 40),
	(41, 'Obat sakit kepala', '1750137278725_Bodrex Migra Box.jpeg', 'Bodrex 4 tablet', 3000, 80),
	(42, 'Obat maag', '1750137290108_Promaag.jpeg', 'Promag 10 tablet', 10000, 50),
	(43, 'Vitamin C', '1750137302306_download (10).jpeg', 'Vitacimin 100 tablet', 15000, 30),
	(44, 'Obat gosok', '1750137314503_Obat Balsem Gosok Lang Untuk Bagian Luar Badan  Produk Negara Indonesia.jpeg', 'Balsem Lang 25gr', 8000, 45),
	(45, 'Obat flu', '1750137327136_DECOLGEN.jpeg', 'Decolgen 4 tablet', 5000, 60),
	(46, 'Rokok kretek tanpa filter', '1750137338124_Pt_Djarum ( merchandizer ).jpeg', 'Djarum Super', 20000, 70),
	(47, 'Rokok putih', '1750137348254_download (11).jpeg', 'Marlboro Red', 30000, 50),
	(48, 'Rokok kretek', '1750137358687_download (12).jpeg', 'Gudang Garam Surya', 22000, 65),
	(49, 'Rokok mild', '1750137368482_Lucky Strike (1991).jpeg', 'Lucky Strike Filter', 28000, 40),
	(50, 'Rokok kretek', '1750137377622_Bentoel International.jpeg', 'Bentoel Biru', 18000, 55);

-- Dumping structure for table kasir.users
CREATE TABLE IF NOT EXISTS `users` (
  `id_user` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `profile` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table kasir.users: ~2 rows (approximately)
INSERT INTO `users` (`id_user`, `name`, `password`, `profile`, `role`, `username`) VALUES
	(1, 'ADMIN', 'admin123', NULL, 'ADMIN', 'admin'),
	(2, 'KASIR', 'kasir123', NULL, 'CASHIER', 'kasir');

-- Dumping structure for table kasir.orders
CREATE TABLE IF NOT EXISTS `orders` (
  `id_order` int NOT NULL AUTO_INCREMENT,
  `order_date` varchar(255) DEFAULT NULL,
  `total_price` double DEFAULT NULL,
  `id_user` int DEFAULT NULL,
  PRIMARY KEY (`id_order`),
  KEY `FKtb6jdc061vu6ydv1445lrigtb` (`id_user`),
  CONSTRAINT `FKtb6jdc061vu6ydv1445lrigtb` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping structure for table kasir.order_list
CREATE TABLE IF NOT EXISTS `order_list` (
  `id_order_list` int NOT NULL AUTO_INCREMENT,
  `id_order` int DEFAULT NULL,
  `id_product` int DEFAULT NULL,
  PRIMARY KEY (`id_order_list`),
  KEY `FKfecjh5cir1y1ipi01vpv7pprb` (`id_order`),
  KEY `FK9j5yhs2jn3lmr0j9jd3pfwc30` (`id_product`),
  CONSTRAINT `FK9j5yhs2jn3lmr0j9jd3pfwc30` FOREIGN KEY (`id_product`) REFERENCES `product` (`id_product`),
  CONSTRAINT `FKfecjh5cir1y1ipi01vpv7pprb` FOREIGN KEY (`id_order`) REFERENCES `orders` (`id_order`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
