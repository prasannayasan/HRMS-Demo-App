<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	
	<xsl:template match="/Employees/Employee">
	<xsl:text>&#xa;</xsl:text>
	
	<Employees>
	<xsl:text>&#xa;</xsl:text>
		
		<Employee>
		<xsl:text>&#xa;</xsl:text>
			<name><xsl:value-of select="name"/></name>
			<xsl:text>&#xa;</xsl:text>
			<age><xsl:value-of select="age"/></age>
			<xsl:text>&#xa;</xsl:text>
			<xsl:choose>
			<xsl:when test="salary &lt; 10000">
			<salary><xsl:value-of select="salary + ((salary*10) div 100)"/></salary>
			</xsl:when>
			<xsl:otherwise><salary><xsl:value-of select="salary"/></salary></xsl:otherwise>
			</xsl:choose>
			<xsl:text>&#xa;</xsl:text>
		</Employee>	
		
		<xsl:text>&#xa;</xsl:text>
	</Employees>
	
	</xsl:template>	
</xsl:stylesheet>