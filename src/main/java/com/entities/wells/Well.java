package com.entities.wells;

import ru.ep.sdo.Entity;
import ru.ep.sdo.annotations.Xml;
import java.math.BigDecimal;

@SuppressWarnings("serial")
@Xml(name = "WELL")
public class Well extends Entity
{
	
	public static final String PROPERTYNAME_WELL_NAME = "wellName";
	public static final String PROPERTYNAME_WELL_ID = "wellId";
	
	@Xml(name = "WELL_NAME")
    private String wellName;
    
    @Xml(name = "WELL_ID")
    private BigDecimal wellId;
    
    public Well() {
    }
    
    public Well(BigDecimal wellId, String wellName) {
    	this.setWellId(wellId);
    	this.setWellName(wellName);
    }
    
	public BigDecimal getWelId() {
        return wellId;
    }

    public void setWellId(BigDecimal wellId) {
    	BigDecimal oldValue = this.wellId;
        this.wellId = wellId;
        firePropertyChange(PROPERTYNAME_WELL_ID, oldValue, wellId);
    }
    
    public String getWellName() {
        return wellName;
    }

    public void setWellName(String wellName) {
    	String oldValue = this.wellName;
        this.wellName = wellName;
        firePropertyChange(PROPERTYNAME_WELL_NAME, oldValue, wellName);
    }
}    
    
    
   
	