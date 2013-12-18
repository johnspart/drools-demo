/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dosideas.drools.ejemplo2.rrhh;

import java.math.BigDecimal;

/**
 *
 * @author rgomez
 */
public class Empleado {

    private String nombre;
    private Integer promedioConocimientos;
    private String cargo;
    private BigDecimal salario;

    public Empleado(String nombre, Integer promedioConocimientos) {
        this.nombre = nombre;
        this.promedioConocimientos = promedioConocimientos;
    }

    @Override
    public String toString() {
        return nombre + " promedio=" + promedioConocimientos +
                " cargo=" + cargo + " salario=" + salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPromedioConocimientos() {
        return promedioConocimientos;
    }

    public void setPromedioConocimientos(Integer promedioConocimientos) {
        this.promedioConocimientos = promedioConocimientos;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

}
