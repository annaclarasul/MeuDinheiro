/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.MeuDinheiro.controller;

@Controller
@RequestMapping("/transacoes")
public class TransacaoController {

    private final TransacaoService transacaoService;

    @Autowired
    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @GetMapping
    public String listarTransacoes(Model model) {
        model.addAttribute("transacoes", transacaoService.getTransacoes());
        return "transacoes/listar";
    }

    @GetMapping("/nova")
    public String novaTransacaoForm(Model model) {
        Transacao transacao = new Transacao();
        model.addAttribute("transacao", transacao);
        model.addAttribute("categorias", transacaoService.getCategorias());
        return "transacoes/nova";
    }

    @PostMapping
    public String adicionarTransacao(@ModelAttribute("transacao") Transacao transacao, BindingResult result) {
        if (result.hasErrors()) {
            return "transacoes/nova";
        }
        transacaoService.addTransacao(transacao);
        return "redirect:/transacoes";
    }

    @GetMapping("/{id}")
    public String exibirTransacao(@PathVariable("id") Long id, Model model) {
        Transacao transacao = transacaoService.getTransacaoById(id);
        if (transacao == null) {
            return "redirect:/transacoes";
        }
        model.addAttribute("transacao", transacao);
        return "transacoes/exibir";
    }

    @GetMapping("/{id}/editar")
    public String editarTransacaoForm(@PathVariable("id") Long id, Model model) {
        Transacao transacao = transacaoService.getTransacaoById(id);
        if (transacao == null
