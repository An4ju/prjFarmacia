package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Farmacia;
import com.example.demo.repositories.FarmaciaRepository;

@Service
public class FarmaciaService {
	
	private final FarmaciaRepository farmaciaRepository;

	@Autowired
	public FarmaciaService(FarmaciaRepository farmaciarepository) {
		this.farmaciaRepository = farmaciarepository;

	}

	public Farmacia salvarFarmacia(Farmacia farmacia) {
		return farmaciaRepository.save(farmacia);

	}

	public Farmacia buscarFarmaciaPorId(Long id) {
		return farmaciaRepository.findById(id).orElse(null);

	}

	public List<Farmacia> buscarTodasFarmacia() {
		return farmaciaRepository.findAll();

	}

	public void excluirFarmacia(Long id) {
		farmaciaRepository.deleteById(id);

	}

	public Farmacia atualizarFarmacia(Long id, Farmacia farmaciaAtualizada) {
		Optional<Farmacia> farmaciaExistente = farmaciaRepository.findById(id);
		if (farmaciaExistente.isPresent()) {
			Farmacia farmacia = farmaciaExistente.get();
			farmacia.setNome(farmaciaAtualizada.getNome());
			farmacia.setBula(farmaciaAtualizada.getBula());
			farmacia.setIdFornecedor(farmaciaAtualizada.getIdFornecedor());
			farmacia.setDataValidade(farmaciaAtualizada.getDataValidade());
			return farmaciaRepository.save(farmacia);
		} else {
			return null;
		}

	}

}

