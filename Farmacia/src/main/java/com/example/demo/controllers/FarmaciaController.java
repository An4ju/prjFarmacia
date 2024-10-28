package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Farmacia;
import com.example.demo.services.FarmaciaService;

@RestController
@RequestMapping("/Farmacia")
public class FarmaciaController {
	
private final FarmaciaService farmaciaService;
	
	@Autowired
	public FarmaciaController(FarmaciaService farmaciaService) {
		this.farmaciaService = farmaciaService;
	}
	
	@PostMapping ("/criar")
	public Farmacia criarFarmacia(@RequestBody Farmacia farmacia) {
		return farmaciaService.salvarFarmacia(farmacia);
	}
	
	@GetMapping
	public List<Farmacia> buscarTodas(){
		return farmaciaService.buscarTodasFarmacia();		
	}
	
	@GetMapping("/{id}")
	public Farmacia buscarPorId(@PathVariable Long id) {
		return farmaciaService.buscarFarmaciaPorId(id);
	}
	
	@DeleteMapping("/{id}")
	public void deletarFarmacia(@PathVariable Long id) {
		farmaciaService.excluirFarmacia(id);
	}
	
	@PutMapping
	public ResponseEntity<Farmacia> atualizarFarmacia(@PathVariable Long id, @RequestBody Farmacia farmacia) {
		Farmacia farmaciaAtualizada = farmaciaService.atualizarFarmacia(id, farmacia);
		if(farmaciaAtualizada != null ) {
			return ResponseEntity.ok(farmaciaAtualizada);
		}
		else {
			return null;
		}
		
	}
}


