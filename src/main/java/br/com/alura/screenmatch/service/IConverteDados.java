package br.com.alura.screenmatch.service;

public interface IConverteDados {
    <T> T obterDados(String jston, Class<T> classe);
}
