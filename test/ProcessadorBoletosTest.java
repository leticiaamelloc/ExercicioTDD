import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ProcessadorBoletosTest {

	@Test
	public void verificaPagamento1() {
		ProcessadorBoleto p = new ProcessadorBoleto();
		
		Fatura f = new Fatura();
		f.setCliente("Leticia");
		f.setData("03/10/2020");
		f.setValorTotal(700.00);
		
		Boleto b1 = new Boleto();
		b1.setData("04/10/2020");
		b1.setCodigo("0001");
		b1.setValorPago(400.00);
		
		Boleto b2 = new Boleto();
		b2.setData("05/10/2020");
		b2.setCodigo("0002");
		b2.setValorPago(300.00);
		
		List<Boleto> listaBoleto = new ArrayList<>();
		listaBoleto.add(b1);
		listaBoleto.add(b2);
		
		boolean processado = p.processa(f, listaBoleto);
		
		assertTrue(processado);
	}
	
	
	
	@Test
	public void verificaPagamento2() {
		ProcessadorBoleto p = new ProcessadorBoleto();
		
		Fatura f = new Fatura();
		f.setCliente("Fernanda");
		f.setData("30/09/2020");
		f.setValorTotal(400.00);
		
		Boleto b1 = new Boleto();
		b1.setData("06/10/2020");
		b1.setCodigo("0003");
		b1.setValorPago(500.00);
		
		Boleto b2 = new Boleto();
		b2.setData("07/10/2020");
		b2.setCodigo("004");
		b2.setValorPago(1000.00);
		
		List<Boleto> listaBoleto = new ArrayList<>();
		listaBoleto.add(b1);
		listaBoleto.add(b2);
		
		boolean processado = p.processa(f, listaBoleto);
		
		assertFalse(processado);
	}

}
