<?xml version="1.0"?>  
<!--
     File:       bottles.xsl
     Purpose:    XSL Version of 99 Bottles of Beer
     Desc:       Transform bottles.xml into output text stream
-->

<xsl:stylesheet
   xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
   version="1.0">

   <xsl:output method="text"/>

   <!-- function to return the number of bottles as a string -->
   <xsl:template name="item">
      <xsl:param name="n"/>

      <!-- n bottles -->
      <xsl:if test="$n > 1">
         <xsl:value-of select="$n"/>
         <xsl:text> </xsl:text>
         <xsl:value-of select="*/container-plural"/>
      </xsl:if>

      <!-- 1 bottle -->
      <xsl:if test="$n = 1">
         <xsl:value-of select="$n"/>
         <xsl:text> </xsl:text>
         <xsl:value-of select="*/container-singular"/>
      </xsl:if>

      <!-- No more -->
      <xsl:if test="$n = 0">
         <xsl:text>No more </xsl:text>
         <xsl:value-of select="*/container-plural"/>
      </xsl:if>

      <!-- of beer -->
      <xsl:text> of </xsl:text>
      <xsl:value-of select="*/item"/>
   </xsl:template>

   <!-- recursive function to sing the verses of the song -->
   <xsl:template name="sing">
      <xsl:param name="quantity"/>

      <!-- get the current number of bottles as a string -->
      <xsl:variable name="itemname">
         <xsl:call-template name="item">
            <xsl:with-param name="n" select="$quantity"/>
         </xsl:call-template>
      </xsl:variable>

      <!-- get the number of bottles after taking one down -->
      <xsl:variable name="itemnext">
         <xsl:call-template name="item">
            <xsl:with-param name="n" select="$quantity - 1"/>
         </xsl:call-template>
      </xsl:variable>

      <!-- "n bottles of beer on the wall," -->
      <xsl:value-of select="$itemname"/>
      <xsl:text> </xsl:text>
      <xsl:value-of select="*/location"/>
      <xsl:text>,&#xA;</xsl:text>

      <!-- "n bottles of beer," -->
      <xsl:value-of select="$itemname"/>
      <xsl:text>,&#xA;</xsl:text>

      <!-- "You take one down, pass it around," -->
      <xsl:value-of select="*/retrieve"/>
      <xsl:text>, </xsl:text>
      <xsl:value-of select="*/distribute"/>
      <xsl:text>,&#xA;</xsl:text>

      <!--" n-1 bottles of beer on the wall." -->
      <xsl:value-of select="$itemnext"/>
      <xsl:text> </xsl:text>
      <xsl:value-of select="*/location"/>
      <xsl:text>.&#xA;&#xA;</xsl:text>

      <!-- recurse to the next bottle of beer -->
      <xsl:if test="$quantity != 1">
         <xsl:call-template name="sing">
            <xsl:with-param name="quantity" select="$quantity - 1"/>
         </xsl:call-template>
      </xsl:if>
   </xsl:template>

   <!-- output the song based on the xml input parameters -->
   <xsl:template match="/">
      <xsl:text>&#xA;&#xA;</xsl:text>
      <xsl:call-template name="sing">
         <xsl:with-param name="quantity" select="*/quantity"/>
      </xsl:call-template>
   </xsl:template>

</xsl:stylesheet>