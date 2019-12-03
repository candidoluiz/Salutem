package com.example.projeto.models;

public class DistribuirDto {

    private ClienteDto cliente;
        private VendedorDto vendedor;
        private Double distancia;

       public  DistribuirDto(ClienteDto cliente, VendedorDto vendedor, Double distancia) {
            this.cliente = cliente;
            this.vendedor = vendedor;
            this.distancia = distancia;
        }

        public ClienteDto getCliente() {
            return cliente;
        }

        public Double getDistancia() {
            return distancia;
        }

        public VendedorDto getVendedor() {
            return vendedor;
        }
}
