package com.triveratech.training.xml.rest;


/**
 * <p>
 * This component and its source code representation are copyright protected
 * and proprietary to Trivera Technologies, LLC, Worldwide D/B/A Trivera Technologies
 *
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
 *
 *  Simple SOAP Client
 *
 * This Java application consumes a web service endpoint and a message filename from its command line,
 * contacts the web service using the endpoint, streams the message document to the service and then waits
 * for and displays the service response on the local console.
 */

import java.io.*;
import java.net.*;

public class RESTClient {

  public static void main(String[] args) {

    try {
      //Set up the Web Service URL
      String WebServiceUrl = args[0];

      //Create the connection where we're going to send the file.
      URL url = new URL(WebServiceUrl);
      URLConnection connection = url.openConnection();
      HttpURLConnection httpConn = (HttpURLConnection) connection;

      httpConn.setRequestMethod("GET");

      //Get the response
      InputStreamReader isr = new InputStreamReader(httpConn.getInputStream());
      BufferedReader in = new BufferedReader(isr);

      String inputLine;
      while ((inputLine = in.readLine()) != null)
        System.out.println(inputLine);
      in.close();

    } catch (Exception e) {
      System.out.println("FaultString: " + e.toString());
      return;
    } //end exception
  }

}
