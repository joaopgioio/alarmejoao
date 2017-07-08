package com.terremoto.alarme;

import org.junit.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;

public class AlarmeTest {
	
	
	@Test
	public void terremotoForte(){
		Exercito exercito = mock(Exercito.class);
		SAMU samu = mock(SAMU.class);
				
				
		Alarme alarme = new Alarme();
		alarme.setExercito(exercito);
		alarme.setSAMU(samu);
		
		alarme.tremorDetectado(8, true);
				
		verify(exercito).suporteTragedia();
		verify(samu).suporteFeridos();
		//Espera que o Exercito seja avisado
	}
	
	@Test
	public void maremotoForte(){
		GuardaCosteira guardaCosteira = mock(GuardaCosteira.class);
		SAMU samu = mock(SAMU.class);
				
				
		Alarme alarme = new Alarme();
		alarme.setGuardaCosteira(guardaCosteira);
		alarme.setSAMU(samu);
		
		alarme.tremorDetectado(8, false);
		
		verify(samu).suporteFeridos();
		verify(guardaCosteira).alertaTsunami();
		//Espera que o Exercito seja avisado
	}
	
	@Test
	public void queimada(){
		CorpoBombeiros corpoBombeiros = mock(CorpoBombeiros.class);
		SAMU samu = mock(SAMU.class);
				
				
		Alarme alarme = new Alarme();
		alarme.setCorpoBombeiros(corpoBombeiros);
		alarme.setSAMU(samu);
		
		alarme.queimadaDetectada();
		
		InOrder inOrder = inOrder(samu, corpoBombeiros);
		inOrder.verify(samu).suporteFeridos();
		inOrder.verify(corpoBombeiros).alertaIncendio();
		//Espera que o Exercito seja avisado
	}
}
