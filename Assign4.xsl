<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
	
	   <xsl:for-each select = "Employees/Employee"> 					
          <xsl:if test = "salary < 10000"> 
                  
              <xsl:text>&#xa;</xsl:text>
              <xsl:value-of select = "salary"/>
                  
          </xsl:if> 
      </xsl:for-each> 
	
	</xsl:template>
</xsl:stylesheet>