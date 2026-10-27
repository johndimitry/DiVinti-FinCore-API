package com.divinti.fincore.ai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.Map;

@Service
public class DiVintiInsightService {
    private final ChatClient chatClient;
    public DiVintiInsightService(ChatClient.Builder builder){ 
        this.chatClient = builder.build(); 
    }

    public String explain(Map<String, BigDecimal> gastos){
        String prompt = "Voce e analista da DiVinti. Cores vermelho preto branco. Explique esses gastos de forma curta, nao execute operacoes: " + gastos;
        return chatClient.prompt().user(prompt).call().content();
    }
    
    public String explainFallback(Map<String, BigDecimal> gastos){
        BigDecimal total = gastos.values().stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        return "DiVinti Insight: Gasto total R$" + total + " - categorias: " + gastos.keySet();
    }
}