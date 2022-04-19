package com;

import java.util.Iterator;
import java.util.Properties;

import com.entities.equipments.Equipment;
import com.entities.wells.Well;

import ru.ep.sdo.Session;
import ru.ep.sdo.SessionFactory;
import ru.ep.sdo.def.SessionMetaData;
import ru.ep.sdo.filter.LikeFilter;
import ru.ep.sdo.list.XMLListModel;
import ru.ep.sdo.tree.XMLTreeListModel;

public class Main {
    public static void main(String[] args) {
    	
    	Properties properties = new Properties();
    	properties.setProperty(SessionMetaData.PROPERTY_DRIVER_CLASS_NAME, "oracle.jdbc.OracleDriver");
    	properties.setProperty(SessionMetaData.PROPERTY_CONNECTION_STRING, 
    			"jdbc:oracle:thin:@10.100.22.13:1521:REMGTM");
    	properties.setProperty(SessionMetaData.PROPERTY_USER, "vsp_test1");
    	properties.setProperty(SessionMetaData.PROPERTY_PASSWORD, "1");
    	
    	Session session = SessionFactory.getInstance().createSessionFromFile("session.xml", properties);
    	XMLListModel listModel = session.getListModel("SDO.Well");
    	
    	listModel.setWhereClause("NAME LIKE ?");
    	listModel.setWhereClauseParam(0, "Тест%");
    	listModel.setFilter(new LikeFilter(
    			new String[] {Well.PROPERTYNAME_WELL_NAME},
    			new Object[] {"Тест%"}));
    	
    	listModel.setOrderClause("NAME ASC");
    	
    	listModel.fetchAllImmediate();
    	
    	Iterator iterator = listModel.iterator();
    	
    	Iterator transientIterator = listModel.transientIterator();
    	
    	listModel.setOrderClause(null);
    	
    	XMLTreeListModel treeListModel = session.getTreeListModel("SDO.WellTree");
    	
    	XMLListModel level = treeListModel.getLevel("SDO.Well");
    	level.setFilter(new LikeFilter(
    			new String[] {Well.PROPERTYNAME_WELL_NAME},
    			new Object[] {"Тест%"}));
    	level.setOrderClause("NAME ASC");
    	
    	XMLListModel listModel1 = session.getListModel("SDO.Equipment");
    	
    	listModel1.setWhereClause("NAME LIKE ?");
    	listModel1.setWhereClauseParam(0, "Тест%");
    	listModel1.setFilter(new LikeFilter(
    			new String[] {Equipment.PROPERTYNAME_EQUIPMENT_NAME},
    			new Object[] {"Тест%"}));
    	
    	listModel1.setOrderClause("NAME ASC");
    	
    	listModel1.fetchAllImmediate();
    	
    	Iterator iterator1 = listModel1.iterator();
    	
    	Iterator transientIterator1 = listModel1.transientIterator();
    	
    	listModel1.setOrderClause(null);
    	
    	XMLTreeListModel treeListModel1 = session.getTreeListModel("SDO.EquipmentTree");
    	
    	XMLListModel level1 = treeListModel.getLevel("SDO.Equipment");
    	level1.setFilter(new LikeFilter(
    			new String[] {Equipment.PROPERTYNAME_EQUIPMENT_NAME},
    			new Object[] {"Тест%"}));
    	level1.setOrderClause("NAME ASC");
    
    }
    
}