package backEnd.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backEnd.model.Produto;
import backEnd.model.exception.ResourceNotFoundException;
import backEnd.repository.ProdutoRepository;
import backEnd.shared.ProdutoDTO;
@Service
public class ProdutoService  {

    @Autowired
    ProdutoRepository repository;
    
    public List<ProdutoDTO> obterTodos (){
    	
    	List<Produto> produtos = repository.findAll();
    	
    	return produtos.stream()
    			.map(produto -> new ModelMapper().map(produto, ProdutoDTO.class))
    			.collect(Collectors.toList());
    			
    			
    }

    public Optional<ProdutoDTO> obterPorId (Integer id){
    	
    	Optional<Produto> produto = repository.findById(id);
    	
    	if (produto.isEmpty()) {
    		throw new ResourceNotFoundException("Produto com o id " + id + "não encontado");
    		
    		 	}
    		ProdutoDTO dto = new ModelMapper().map (produto.get(),ProdutoDTO.class);
    		
    		return Optional.of(dto);
  
    }
    
    
    
	 public ProdutoDTO adicionar (ProdutoDTO produtoDto){
		 
		 produtoDto.setId(null);
		 
		 ModelMapper mapper = new ModelMapper();
		 
		 Produto produto = mapper.map(produtoDto, Produto.class);
		 
		 produto = repository.save(produto);
		 
		 produtoDto.setId(produto.getId());
		 
		 return produtoDto;
	        
	    }
	 
	 
	 

		 public void deletar (Integer id) {
			 
			 Optional<Produto> produto = repository.findById(id);
			 
			 if (produto.isEmpty()) {
				 throw new ResourceNotFoundException("Não foi possível deletar o produto com o id " + id + ", Produto não encontado" );
			 }
			 
		    repository.deleteById(id);;
		 }
		 
		 
		 
		 public ProdutoDTO atualizar (Integer id, ProdutoDTO produtoDto){
				            
			 produtoDto.setId(id);
			 
			 ModelMapper mapper = new ModelMapper();
			 
			 Produto produto = mapper.map(produtoDto, Produto.class);
			 
			 repository.save(produto);
			 
			 return produtoDto;
			 
			 
			 
			  
	    }
		 
    
}
