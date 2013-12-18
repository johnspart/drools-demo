[condition][]El promedio de conocimientos esta entre {promedioMinimo} y {promedioMaximo} 
= empleado : Empleado(promedioConocimientos >= {promedioMinimo} &&  <= {promedioMaximo})

[consequence][]Ascender a {cargo} = empleado.setCargo({cargo});
[consequence][]El salario es de {salario} pesos = empleado.setSalario(BigDecimal.valueOf({salario}));
[consequence][]Imprimir {cargo}: nombre = System.out.println({cargo} + ": " + empleado.getNombre());