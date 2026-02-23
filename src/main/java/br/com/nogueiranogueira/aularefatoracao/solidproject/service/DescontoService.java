package br.com.nogueiranogueira.aularefatoracao.solidproject.service;

import br.com.nogueiranogueira.aularefatoracao.solidproject.model.Descontavel;
import br.com.nogueiranogueira.aularefatoracao.solidproject.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DescontoService {
    public int calculaDescontoTotal(List<Descontavel> descontavels) {
        return descontavels.stream()
                .mapToInt(Descontavel::getDesconto)
                .sum();
    }
}
