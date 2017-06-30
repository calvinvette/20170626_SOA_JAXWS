
package com.trivera.costservice.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.trivera.costservice.generated package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Cost_QNAME = new QName("http://triveratech.com/CostCalc/", "cost");
    private final static QName _Items_QNAME = new QName("http://triveratech.com/CostCalc/", "items");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.trivera.costservice.generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Float }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://triveratech.com/CostCalc/", name = "cost")
    public JAXBElement<Float> createCost(Float value) {
        return new JAXBElement<Float>(_Cost_QNAME, Float.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Float }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://triveratech.com/CostCalc/", name = "items")
    public JAXBElement<Float> createItems(Float value) {
        return new JAXBElement<Float>(_Items_QNAME, Float.class, null, value);
    }

}
