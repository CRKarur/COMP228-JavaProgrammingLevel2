module ChandrikaRathnaKarur_COMP228Sec004 {
	requires javafx.controls;
	requires java.sql;
	requires java.desktop;
	requires javafx.fxml;
	requires javafx.base;
	
	opens chandrikarathnakarur_sec004_ex01 to javafx.controls, javafx.base, javafx.graphics, javafx.fxml;
}
