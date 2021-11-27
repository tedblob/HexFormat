package com.tedblob.java.hexformat;

import java.util.Arrays;
import java.util.HexFormat;
import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ch.qos.logback.classic.Level;


@SpringBootApplication
public class HexFormatApplication implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(HexFormatApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		HexFormat hex = HexFormat.of().withUpperCase();
	     byte b = 127;
	     String byteStr = hex.toHexDigits(b);
	     System.out.println("toHexDigits(byte) : " + byteStr);
	     

	     char hexChar = '▙';
	     short shortChar = (short) hexChar;
	     String charStr = hex.toHexDigits(hexChar);
	     System.out.println("toHexDigits(char) : " + shortChar + " " + charStr);
	     
	     short shortValue = 33;
	     System.out.println("toHexDigits(short) : " + hex.toHexDigits(shortValue));
	     

	     int intValue = 33;
	     System.out.println("toHexDigits(int) : " + hex.toHexDigits(intValue));

	     long longValue = 33;
	     System.out.println("toHexDigits(long) : " + hex.toHexDigits(longValue, 2));
	     
	     String hexValue = "7F89";
	     int decimalValue = HexFormat.fromHexDigit(hexValue.charAt(1));
	     System.out.println("fromHexDigit(int ch)" + decimalValue);

	     decimalValue = HexFormat.fromHexDigits(hexValue);
	     System.out.println("fromHexDigit(int ch)" + decimalValue);
	     
	     decimalValue = HexFormat.fromHexDigits(hexValue, 0, 2);
	     System.out.println("fromHexDigit(int ch)" + decimalValue);
	     
	     HexFormat hexFormat = HexFormat.ofDelimiter(".");
	     hexFormat = hexFormat.withPrefix("#");
	     hexFormat = hexFormat.withSuffix("%");
	     byte[] bytes = {0, 1, 2, 3, 124, 125, 126, 127};
	     String str = hexFormat.formatHex(bytes);
	     System.out.println("Byte Array to Hexadecimal formatted string: " + str);

	     byte[] parsed = hexFormat.parseHex(str);
	     System.out.println("Arrays.equals(bytes, parse):" +Arrays.equals(bytes, parsed));
	     /* prints Byte Array to Hexadecimal formatted string: 00.01.02.03.7C.7D.7E.7F */

			/*
			 * byte[] parsed = commaFormat.parseHex(str); assert(Arrays.equals(bytes,
			 * parsed));
			 */

	}

}
