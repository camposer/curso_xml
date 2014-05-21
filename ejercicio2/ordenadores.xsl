<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/ordenadores">
	<html>
	<head>
		<meta charset="utf-8"/>
		<style>
			h1 {
				text-align: center;
			}

			table {
				border: 2px dashed black;
				margin-left: auto;
				margin-right: auto;
			}

			th {
				background-color: navy;
				color: white;
			}

			tr:nth-child(odd) {
				background-color: darkgray;
			}

			tr:nth-child(even) {
				background-color: lightgray;
			}

			.diferente {
				background-color: lightblue !important;
			}
		</style>
	</head>
	<body>
		<h1>Ordenadores</h1>
		<table>	
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Serial</th>
				<th>Dueño</th>
			</tr>
			<xsl:apply-templates select="ordenador"/>
		</table>
	</body>
	</html>
</xsl:template>

<xsl:template match="ordenador">
	<xsl:choose>
		<xsl:when test="persona/altura &gt; 170">
			<tr class="diferente">
				<xsl:call-template name="ordenadorTemplate"/>
			</tr>
		</xsl:when>
		<xsl:otherwise>
			<tr>
				<xsl:call-template name="ordenadorTemplate"/>
			</tr>
		</xsl:otherwise>
	</xsl:choose>
		
</xsl:template>

<xsl:template name="ordenadorTemplate">
	<td><xsl:value-of select="@id"/></td>
	<td><xsl:value-of select="nombre"/></td>
	<td><xsl:value-of select="serial"/></td>
	<td><xsl:apply-templates select="persona"/></td>
</xsl:template>

<xsl:template match="persona">
	<ul>
		<li>Id: <xsl:value-of select="@id"/></li>
		<li>Nombre: <xsl:value-of select="nombre"/></li>
		<li>Apellido: <xsl:value-of select="apellido"/></li>
		<li>Fecha de Nacimiento: <xsl:value-of select="fechaNacimiento"/></li>
		<li>Altura: <xsl:value-of select="altura"/></li>
	</ul>
</xsl:template>

</xsl:stylesheet> 
