package com.triveratech.training.xml.rest;

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
 *
 *  Simple SOAP Client
 *
 * This Java application consumes a web service endpoint and a message filename from its command line,
 * contacts the web service using the endpoint, streams the message document to the service and then waits
 * for and displays the service response on the local console.
 */

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class RESTCustomerUpdate {
  /** ***************************************************************** */
  /** ***********************Variables********************************* */
  /** ***************************************************************** */
  DocumentBuilder domBuilder = null;
  DOMErrorHandler thisHandler = null;
  StringBuffer collector = new StringBuffer();
  Document mainDocument = null;
  String customerId = null;

  /** ***************************************************************** */
  /** ***********************Constructor******************************* */
  /** ***************************************************************** */

  public RESTCustomerUpdate() {
    super();

  }

  public static void main(String[] args) {
    RESTCustomerUpdate thisUpdate = new RESTCustomerUpdate();
    // Set up the invoice id
    String invoiceId = args[0];
    if (invoiceId == null)
      return;

    //Connect to query for the invoice, capturing in collector
    thisUpdate.getRESTed("", "", null);

    //Process invoice, extracting customer, assign to customerId
    thisUpdate.processInvoice();

    //Connect to query for the customer, capturing in collector
    thisUpdate.getRESTed("", "", null);

    //Build the payload of the upcoming POST
    thisUpdate.constructPayload();

    //Send the payload to the service
    thisUpdate.getRESTed("", "", thisUpdate.collector);

    //Just to check, connect to query for the customer, capturing in collector
    thisUpdate.getRESTed("", "", null);

  }

  private void getRESTed(String urlString, String method, StringBuffer payload) {


      //Create the connection where we're going to send the file.
      //(Use RESTClient as an example for this)

      //setRequestMethod(method) for the connection

      //If there is a payload, send it out
      if (payload != null){
        //setDoOutput to true on the URL connection so you can write
        //Send XML (see SOAPClient for example of writing)
        System.out.println("Sending: " + payload.toString());

        //To write a StringBuffer out to a stream:
        //payload.toString().getBytes("UTF-8")

      };

      // Get the response and collect in the collector StringBuffer
      //(Use RESTClient as an example for this)


  }

  private void processInvoice() {
    createDOMParser();

    // Check for parser, if not there, drop out....
    if (domBuilder == null) {
      handleError("There is no DOM parser available!");
      return;
    }
    ;

    // Now try and parse the XML using ByteArrayInputStream as input
    //Convert StringBuffer to a ByteArrayInputStream using:
    //toString().getBytes("UTF-8")

    // Indicate success
    if (!thisHandler.isValid())
      return;

    //Extract out the value of the CUSTOMERID tag and assign to customerId


    System.out.println("Customer: " + customerId);
  }

  private void constructPayload() {
    collector.delete(0, collector.length());
    //Payload should be basic: <resources><CITY>Shoup</CITY></resources>
  }


  /** ***************************************************************** */
  /** *******************JAXP Methods************************ */
  /** ***************************************************************** */

  /**
   * You need to create a parser.  We have created a DOM parser, but
   * you can create whichever type you would like
   */
  private void createDOMParser() {
    if (domBuilder != null)
      return;

    // Create a DocumentBuilderFactory

    // Create a JAXP DocumentBuilder

    // Set ErrorHandler to DOMErrorHandler

  }

  /** ***************************************************************** */
  /** ***********************Utility Methods*************************** */
  /** ***************************************************************** */

  /**
   * Method handles error conditions by constructing appropriate string
   *
   * @parameter message String containing characters for error message.
   */
  private void handleError(String baseMessage) {
    System.err.print(baseMessage);
  }

}
