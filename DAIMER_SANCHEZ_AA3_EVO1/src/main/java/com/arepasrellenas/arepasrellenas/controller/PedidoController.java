package com.arepasrellenas.arepasrellenas.controller;

import ch.qos.logback.core.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/nuevo")
    public String showNuevoPedidoForm(Model model) {
        model.addAttribute("pedido", new Pedido());
        return "nuevo_pedido";
    }

    @PostMapping("/nuevo")
    public String crearPedido(@ModelAttribute("pedido") Pedido pedido) {
        pedidoService.savePedido(pedido);
        return "redirect:/pedidos/lista";
    }

    @GetMapping("/lista")
    public String listarPedidos(Model model) {
        model.addAttribute("pedidos", pedidoService.findAllPedidos());
        return "lista_pedidos";
    }
}