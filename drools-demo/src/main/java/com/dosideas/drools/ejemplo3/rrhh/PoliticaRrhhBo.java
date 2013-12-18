/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dosideas.drools.ejemplo3.rrhh;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;

import org.drools.compiler.compiler.PackageBuilder;
import org.drools.core.RuleBase;
import org.drools.core.RuleBaseFactory;
import org.drools.core.WorkingMemory;
import org.drools.decisiontable.InputType;
import org.drools.decisiontable.SpreadsheetCompiler;

/**
 * 
 * @author rgomez
 */
public class PoliticaRrhhBo {

	public static final void main(String[] args) throws Exception {
		// Cargamos la base de reglas
		RuleBase ruleBase = leerReglas();
		WorkingMemory workingMemory = ruleBase.newStatefulSession();

		// Obtenemos los empleados
		Collection<Empleado> empleados = buscarEmpleados();

		for (Empleado empleado : empleados) {
			workingMemory.insert(empleado);
		}

		// Disparamos las reglas de Drools
		workingMemory.fireAllRules();

		for (Empleado empleado : empleados) {
			System.out.println("Empleado: " + empleado);
		}
	}

	private static Collection<Empleado> buscarEmpleados() {
		ArrayList<Empleado> empleados = new ArrayList<Empleado>();

		// Creamos algunos empleados para el ejemplo
		Empleado empleado1 = new Empleado("Juan", 9);
		Empleado empleado2 = new Empleado("Jose", 6);
		Empleado empleado3 = new Empleado("Pedro", 2);

		empleados.add(empleado1);
		empleados.add(empleado2);
		empleados.add(empleado3);

		return empleados;
	}

	private static RuleBase leerReglas() throws Exception {
		// Leemos el archivo de reglas desde una planilla Excel
		SpreadsheetCompiler converter = new SpreadsheetCompiler();
		String drl = converter.compile(PoliticaRrhhBo.class
				.getResourceAsStream("PoliticaRrhh_Ej3.xls"), InputType.XLS);

		// Solo mostramos el DRL que se generó del Excel. Comentar para no
		// imprimirlo.
		System.out.println(drl);

		// Construimos un paquete de reglas
		PackageBuilder builder = new PackageBuilder();

		// Leemos el drl del generado del Excel
		builder.addPackageFromDrl(new StringReader(drl));

		// Verificamos el builder para ver si hubo errores
		if (builder.hasErrors()) {
			System.out.println(builder.getErrors().toString());
			throw new RuntimeException(
					"No se pudo compilar el archivo de reglas.");
		}

		// Obtenemos el package de reglas compilado
		org.drools.core.rule.Package pkg = builder.getPackage();

		// Agregamos el paquete a la base de reglas (desplegamos el paquete de
		// reglas).
		RuleBase ruleBase = RuleBaseFactory.newRuleBase();
		ruleBase.addPackage(pkg);
		return ruleBase;
	}
}
