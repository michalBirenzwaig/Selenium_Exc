package com.simplilearn.mavenproject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.xpath.operations.Bool;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.xml.sax.SAXException;

import com.opencsv.exceptions.CsvValidationException;

import Helpers.CSVHelper;
import Pages.HTMLTables;

/**
 * Unit test for simple App.
 */
public class AppTest extends BasePage
{
	private static final Logger logger = LogManager.getLogger(AppTest.class);

    @Test
    public void findValueByXpath() throws Exception
    {
    	String nameFile="data";
        HTMLTables htmlTables=new HTMLTables();
        String value=htmlTables.getTableCellTextByXpath(htmlTables.getTableElement(driver),
        		Integer.parseInt(CSVHelper.read(nameFile,"searchColumn")),CSVHelper.read(nameFile,"searchText"),
        		Integer.parseInt(CSVHelper.read(nameFile,"returnColumnText")));
        logger.info(value);
        Assert.assertEquals(CSVHelper.read(nameFile, "expectedText"),value);
    }

    @Test
    public void findValue() throws NumberFormatException, CsvValidationException
    {
    	String nameFile="data";
        HTMLTables htmlTables=new HTMLTables();
        String value=htmlTables.getTableCellText(htmlTables.getTableElement(driver),
        		Integer.parseInt(CSVHelper.read(nameFile,"searchColumn")),CSVHelper.read(nameFile,"searchText"),
        		Integer.parseInt(CSVHelper.read(nameFile,"returnColumnText")));
        logger.info(value);
        Assert.assertEquals(CSVHelper.read(nameFile, "expectedText"),value);
    }
    
 
    @Test
    public void ValidationValue() throws Exception
    {
    	String nameFile="data";
        HTMLTables htmlTables=new HTMLTables();
        Boolean result=htmlTables.verifyTableCellText(htmlTables.getTableElement(driver),
        		Integer.parseInt(CSVHelper.read(nameFile,"searchColumn")),CSVHelper.read(nameFile,"searchText"),
        		Integer.parseInt(CSVHelper.read(nameFile,"returnColumnText")),CSVHelper.read(nameFile, "expectedText"));
        Assert.assertTrue(result);
    }
 
}