package io.github.davidrodrigues.domain.repository;

import io.github.davidrodrigues.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface Clientes extends JpaRepository<Cliente, Integer> {

    @Query(value = "select * from cliente c where c.nome like '%:nome%'", nativeQuery = true)
    List<Cliente> econtrarPorNome( @Param("nome") String nome);

    @Query(value = " delete from Cliente c where c.nome =:nome")
    @Modifying
    void deleteByNome(String nome);

//    List<Cliente>findByNomeOrIdOrderById(String nome, Integer id);

    boolean existsByNome(String Nome);

    @Query("select c from Cliente c left join fetch c.pedidos p where c.id =:id ")
    Cliente findClienteFetchPedidos(@Param("id") Integer id);




//    //private static String INSERT = "insert into CLIENTE (NOME) values(?)";
//    //private static String SELECT_ALL = "select * from CLIENTE";
//    //private static String UPDATE = "update CLIENTE set NOME= ? where id= ?";
//    //private static String DELETE = "delete from CLIENTE where id= ?";
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    private EntityManager entityManager;
//
//    @Transactional
//    public Cliente salvar(Cliente cliente){
//        entityManager.persist(cliente);
//
//        //jdbcTemplate.update(INSERT,new Object[]{cliente.getNome()});
//        return cliente;
//
//    }
//    @Transactional
//    public Cliente atualizar(Cliente cliente){
//        entityManager.merge(cliente);
//
//        //jdbcTemplate.update(UPDATE,new Object[]{cliente.getNome(),cliente.getId()} );
//        return cliente;
//    }
//    @Transactional
//    public void deletar(Cliente cliente){
//        if(!entityManager.contains(cliente)){
//            cliente = entityManager.merge(cliente);
//
//        }
//        entityManager.remove(cliente);
//
//        //deletar(cliente.getId());
//    }
//    @Transactional
//    public void deletar(Integer id){
//
//        Cliente cliente = entityManager.find(Cliente.class, id);
//        deletar(cliente);
//
//        //jdbcTemplate.update(DELETE,new Object[]{id} );
//
//    }
//
//    @Transactional(readOnly = true)
//    public List<Cliente> buscarPorNome(String nome){
//
//        String  jpql = "select c from Cliente c where c.nome like :nome";
//        TypedQuery<Cliente> query = entityManager.createQuery(jpql, Cliente.class);
//        query.setParameter("nome","%"+nome+"%");
//        return query.getResultList();
//
////        return jdbcTemplate.query(SELECT_ALL.concat(" where nome like ? "),
////                new Object[]{"%"+ nome +"%"},
////                obterClienteMapper());
//
//
//    }
//    @Transactional
//    public List<Cliente> obterTodos(){
//        return entityManager.createQuery("from Cliente", Cliente.class).getResultList();
//
//
////        return jdbcTemplate.query(
////                SELECT_ALL, obterClienteMapper());
//    }

//    private RowMapper<Cliente> obterClienteMapper() {
//        return new RowMapper<Cliente>() {
//            @Override
//            public Cliente mapRow(ResultSet resultSet, int i) throws SQLException {
//                Integer id = resultSet.getInt("id");
//                String nome = resultSet.getString("nome");
//                return new Cliente(id, nome);
//            }
//        };
//    }
}

