//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.06.29 at 02:32:39 PM UTC 
//


package personnel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PERSONType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PERSONType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}FUNCTION"/>
 *         &lt;element ref="{}ROOMNR"/>
 *         &lt;element ref="{}WORKPHONE1"/>
 *         &lt;element ref="{}WORKPHONE2"/>
 *         &lt;element ref="{}E_MAIL_ADDRESS"/>
 *         &lt;element ref="{}LOGIN"/>
 *         &lt;element name="HOME_ADDRESS" type="{}HOME_ADDRESSType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="SURNAME" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="GIVENNAME" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="OFFICIAL_NAME" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PERSONType", propOrder = {
    "function",
    "roomnr",
    "workphone1",
    "workphone2",
    "emailaddress",
    "login",
    "homeaddress"
})
public class PERSONType {

    @XmlElement(name = "FUNCTION", required = true)
    protected String function;
    @XmlElement(name = "ROOMNR", required = true)
    protected String roomnr;
    @XmlElement(name = "WORKPHONE1")
    protected short workphone1;
    @XmlElement(name = "WORKPHONE2")
    protected short workphone2;
    @XmlElement(name = "E_MAIL_ADDRESS", required = true)
    protected String emailaddress;
    @XmlElement(name = "LOGIN", required = true)
    protected String login;
    @XmlElement(name = "HOME_ADDRESS", required = true)
    protected HOMEADDRESSType homeaddress;
    @XmlAttribute(name = "SURNAME", required = true)
    protected String surname;
    @XmlAttribute(name = "GIVENNAME", required = true)
    protected String givenname;
    @XmlAttribute(name = "OFFICIAL_NAME", required = true)
    protected String officialname;

    /**
     * Gets the value of the function property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFUNCTION() {
        return function;
    }

    /**
     * Sets the value of the function property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFUNCTION(String value) {
        this.function = value;
    }

    /**
     * Gets the value of the roomnr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getROOMNR() {
        return roomnr;
    }

    /**
     * Sets the value of the roomnr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setROOMNR(String value) {
        this.roomnr = value;
    }

    /**
     * Gets the value of the workphone1 property.
     * 
     */
    public short getWORKPHONE1() {
        return workphone1;
    }

    /**
     * Sets the value of the workphone1 property.
     * 
     */
    public void setWORKPHONE1(short value) {
        this.workphone1 = value;
    }

    /**
     * Gets the value of the workphone2 property.
     * 
     */
    public short getWORKPHONE2() {
        return workphone2;
    }

    /**
     * Sets the value of the workphone2 property.
     * 
     */
    public void setWORKPHONE2(short value) {
        this.workphone2 = value;
    }

    /**
     * Gets the value of the emailaddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEMAILADDRESS() {
        return emailaddress;
    }

    /**
     * Sets the value of the emailaddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEMAILADDRESS(String value) {
        this.emailaddress = value;
    }

    /**
     * Gets the value of the login property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLOGIN() {
        return login;
    }

    /**
     * Sets the value of the login property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLOGIN(String value) {
        this.login = value;
    }

    /**
     * Gets the value of the homeaddress property.
     * 
     * @return
     *     possible object is
     *     {@link HOMEADDRESSType }
     *     
     */
    public HOMEADDRESSType getHOMEADDRESS() {
        return homeaddress;
    }

    /**
     * Sets the value of the homeaddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link HOMEADDRESSType }
     *     
     */
    public void setHOMEADDRESS(HOMEADDRESSType value) {
        this.homeaddress = value;
    }

    /**
     * Gets the value of the surname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSURNAME() {
        return surname;
    }

    /**
     * Sets the value of the surname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSURNAME(String value) {
        this.surname = value;
    }

    /**
     * Gets the value of the givenname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGIVENNAME() {
        return givenname;
    }

    /**
     * Sets the value of the givenname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGIVENNAME(String value) {
        this.givenname = value;
    }

    /**
     * Gets the value of the officialname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOFFICIALNAME() {
        return officialname;
    }

    /**
     * Sets the value of the officialname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOFFICIALNAME(String value) {
        this.officialname = value;
    }

}
