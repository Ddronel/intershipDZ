package com.entities.equipments;

import ru.ep.sdo.Entity;
import ru.ep.sdo.annotations.Xml;
import java.math.BigDecimal;

@Xml(name = "EQUIPMENT")
public class Equipment extends Entity
{
	public static final String PROPERTYNAME_EQUIPMENT_NAME = "equipmentName";
	public static final String PROPERTYNAME_EQUIPMENT_ID = "equipmentId";
	public static final String PROPERTYNAME_EQUIPMENT_WELL_ID = "equipmentWellId";
	
	@Xml(name = "EQUIPMENT_NAME")
    private String equipmentName;
    
    @Xml(name = "EQUIPMENT_ID")
    private BigDecimal equipmentId;
    
    @Xml(name = "EQUIPMENT_WELL_ID")
    private BigDecimal equipmentWellId;
    
    public Equipment() {
    }
    
    public Equipment(BigDecimal equipmentId, String equipmentName, BigDecimal equipmentWellId) {
    	this.setEquipmentId(equipmentId);
    	this.setEquipmentName(equipmentName);
    	this.setEquipmentWellId(equipmentWellId);
    }
    
	public BigDecimal getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(BigDecimal equipmentId) {
    	BigDecimal oldValue = this.equipmentId;
        this.equipmentId = equipmentId;
        firePropertyChange(PROPERTYNAME_EQUIPMENT_ID, oldValue, equipmentId);
    }
    
    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
    	String oldValue = this.equipmentName;
        this.equipmentName = equipmentName;
        firePropertyChange(PROPERTYNAME_EQUIPMENT_NAME, oldValue, equipmentName);
    }
    
    public BigDecimal getEquipmentWellId() {
        return equipmentWellId;
    }

    public void setEquipmentWellId(BigDecimal equipmentWellId) {
    	BigDecimal oldValue = this.equipmentWellId;
        this.equipmentWellId = equipmentWellId;
    	firePropertyChange(PROPERTYNAME_EQUIPMENT_WELL_ID, oldValue, equipmentWellId);
    }
}