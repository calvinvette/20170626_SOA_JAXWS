package com.triveratech.training.jaxb;

import static javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.bind.ValidationEventLocator;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import personnel.PERSONType;
import personnel.Personnel;

/**
 * <p>
 * This component and its source code representation are copyright protected
 * and proprietary to Trivera Technologies, LLC, Worldwide D/B/A Trivera Technologies
 *
 * This component and source code may be used for instructional and
 * evaluation purposes only. No part of this component or its source code
 * may be sold, transferred, or publicly posted, nor may it be used in a
 * commercial or production environment, without the express written consent
 * of Trivera Technologies, LLC
 *
 * Copyright (c) 2017 Trivera Technologies, LLC.
 * http://www.triveratech.com   
 * </p>
 * @author Trivera Technologies Tech Team.
 */



public class ReadValid {

    // This sample application demonstrates how to unmarshal an instance
    // document into a Java content tree and access data contained within it.

    public static void main( String[] args ) {
        try {
            // create a JAXBContext capable of handling classes generated into
            // the personnel package
            JAXBContext jc = JAXBContext.newInstance( "personnel" );

            // create an Unmarshaller
            Unmarshaller u = jc.createUnmarshaller();
            SchemaFactory sf = SchemaFactory.newInstance(W3C_XML_SCHEMA_NS_URI);
            try {
                Schema schema = sf.newSchema(new File("personnel.xsd"));
                u.setSchema(schema);
                u.setEventHandler(
                    new ValidationEventHandler() {
                        // allow unmarshalling to continue even if there are errors
                        public boolean handleEvent(ValidationEvent ve) {
                            // ignore warnings
                            if (ve.getSeverity() != ValidationEvent.WARNING) {
                                ValidationEventLocator vel = ve.getLocator();
                                System.out.println("Line:Col[" + vel.getLineNumber() +
                                    ":" + vel.getColumnNumber() +
                                    "]:" + ve.getMessage());
                            }
                            return true;
                        }
                    }
                );
            } catch (org.xml.sax.SAXException se) {
                System.out.println("Unable to validate due to following error.");
                se.printStackTrace();
            }

            // unmarshal an invalid instance document into a tree of Java
            // content objects composed of classes from the personnel package.
            System.out.println("NOTE: This sample is working correctly if you see validation errors!!");
            Object poe =
                u.unmarshal( new File( "personnel.xml" ) );

            Personnel ps = (Personnel)poe;

            // examine some of the content in the Personnel
            System.out.println( "Person Count:" );
            // display the Person Count
            List people = ps.getPERSON();
            System.out.println(people.size());

            displayPeople(people);

            // even though document was determined to be invalid unmarshalling,
            // marshal out result.
            System.out.println("");
            System.out.println("Still able to marshal invalid document");
            Marshaller m = jc.createMarshaller();
            m.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE );
            m.marshal(poe, System.out);

        } catch( JAXBException je ) {
            je.printStackTrace();
        }
    }

    public static void displayPeople( List peopleList ) {
        // the peopleList object contains a List of personnel.PEOPLEType objects

        // iterate over List
        for( Iterator iter = peopleList.iterator(); iter.hasNext(); ) {
            PERSONType person = (PERSONType)iter.next();
            System.out.println( "\t" + person.getGIVENNAME() +
                                " " + person.getSURNAME());
        }
    }
}
