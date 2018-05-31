package co.com.utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import co.com.mapeo.entity.Response;

public final class ServicesConfiguration {
	
	public static int caluteYearDates(String fecha) {
		int años = 0;
		try {
			DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate fn = LocalDate.parse(fecha, fmt);
			Period periodo = Period.between(fn, LocalDate.now());
			años = periodo.getYears();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return años;
	}
	
	public static double validateSalary(double salary) {
		double valorAprobado = 0;
		if(salary <= 800000) {
			valorAprobado = 0;
		}else if(salary > 800000 && salary <= 1000000) {
			valorAprobado = 5000000;
		}else if(salary > 1000000 && salary <= 4000000) {
			valorAprobado = 20000000;
		}else if(salary >= 100000000) {
			valorAprobado = 1;
		}else if(salary > 4000000) {
			valorAprobado = 50000000;
		}
		return valorAprobado;	
	}
	
	public static Response response(String message, String status) {
		Response res = new Response();
		if(message != null && status != null) {
			res.setMessage(message);
			res.setStatus(status);    
		}
		return res;
	}
}
