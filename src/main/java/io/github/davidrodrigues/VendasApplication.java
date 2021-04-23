package io.github.davidrodrigues;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class VendasApplication extends SpringBootServletInitializer {

//    @Bean
//    public CommandLineRunner init(@Autowired Clientes clientes,
//    @Autowired Pedidos pedidos){
//        return args -> {
//
//            System.out.println("Salvando Cliente!");
//            Cliente fulano = new Cliente("David");
//            clientes.save(fulano);
//
//            List<Cliente> result = clientes.econtrarPorNome("David");
//            result.forEach(System.out::println);
//
//            Pedido p = new Pedido();
//            p.setCliente(fulano);
//            p.setDatapedido(LocalDate.now());
//            p.setTotal(BigDecimal.valueOf(100));
//
//            pedidos.save(p);
//
////            Cliente cliente = clientes.findClienteFetchPedidos(fulano.getId());
////            System.out.println(cliente);
////            System.out.println(cliente.getPedidos());
//
//            pedidos.findByCliente(fulano).forEach(System.out::println);
//
//
//
////            System.out.println("Atualizando Clientes!");
////            todosClientes.forEach(c ->{
////                c.setNome(c.getNome() + " atualizado.");
////                clientes.save(c);
////
////                    });
////
////            todosClientes = clientes.findAll();
////            todosClientes.forEach(System.out::println);
////
////            System.out.println("Buscando Clientes!");
////            clientes.findByNomeLike("Dav").forEach(System.out::println);
////
////            System.out.println("Deletando Clientes!");
////            clientes.findAll().forEach(c ->{
////                clientes.delete(c);
////            });
////
////            todosClientes = clientes.findAll();
////            if(todosClientes.isEmpty()){
////                System.out.println("Nenhum cliente!");
////            }else{
////                todosClientes.forEach(System.out::println);
////            }
////
//
//        };
//    }
//    @Bean
//    public CommandLineRunner commandLineRunner(@Autowired Clientes clientes){
//        return args -> {
//            Cliente c = new Cliente(null, "David");
//            clientes.save(c);
//
//
//        };
//
//
//    }

    public static void main(String[] args) {

        SpringApplication.run(VendasApplication.class, args);
    }
}