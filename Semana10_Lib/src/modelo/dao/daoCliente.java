package modelo.dao;

import java.util.ArrayList;
import java.util.List;
import modelo.dominio.operacionesBD;
import modelo.entidad.Cliente;

public class daoCliente {
    private List<Cliente> lst;

    // Constructor que inicializa la lista de clientes
    public daoCliente() {
        this.lst = new ArrayList();
    }

    // Método para obtener todos los clientes de la base de datos
    public List<Cliente> getAll() {
        // Construir la consulta SQL para la consulta de la tabla
        String sql = "SELECT idCliente, nombre, apellido FROM Cliente";
        operacionesBD op = new operacionesBD();
        
        List<Object[]> lista = op.consultar(sql);
        this.lst = new ArrayList();
        for (int i = 0; i < lista.size(); i++) {
            Cliente cli = new Cliente();
            cli.setIdCliente(Integer.parseInt(lista.get(i)[0].toString()));
            cli.setNombre(lista.get(i)[1].toString());
            cli.setApellido(lista.get(i)[2].toString());
            this.lst.add(cli);
        }
        return this.lst;
    }

    // Método para insertar un nuevo cliente en la base de datos
    public int insertarCliente(Cliente cli) {
        int resultado = 0;
        operacionesBD op = new operacionesBD();
        
        // Construir la consulta SQL para la inserción
        String sql = "INSERT INTO Cliente (nombre, apellido) VALUES ('" + cli.getNombre() + "','" + cli.getApellido() + "')";
        
        // Ejecutar la consulta y obtener el resultado
        resultado = op.ejecutar(sql);
        return resultado;
    }

    // Método para actualizar un cliente existente en la base de datos
    public int actualizarCliente(Cliente cli) {
        int resultado = 0;

        // Construir la consulta SQL para la actualización
        String sql = "UPDATE Cliente SET nombre='" + cli.getNombre() + "', apellido='" + cli.getApellido() + "' WHERE idCliente=" + cli.getIdCliente();
        operacionesBD op = new operacionesBD();
        
        // Ejecutar la consulta y obtener el resultado
        resultado = op.ejecutar(sql);
        return resultado;
    }

    // Método para eliminar un cliente de la base de datos por su ID
    public int eliminarCliente(int id) {
        int resultado = 0;

        // Construir la consulta SQL para la eliminación
        String sql = "DELETE FROM Cliente WHERE idCliente=" + id;
        operacionesBD op = new operacionesBD();
        
        // Ejecutar la consulta y obtener el resultado
        resultado = op.ejecutar(sql);
        return resultado;
    }
    
    // Método para obtener un cliente por su ID
    public Cliente getClienteByID(int idCliente) {
        Cliente cliente = null;
        operacionesBD op = new operacionesBD();
        
        // Construir la consulta SQL para obtener el cliente por su ID
        String sql = "SELECT idCliente, nombre, apellido FROM Cliente WHERE idCliente = " + idCliente;
        
        // Ejecutar la consulta y obtener los resultados
        List<Object[]> resultados = op.consultar(sql);
        if (resultados != null && !resultados.isEmpty()) {
            // Si se encontraron resultados, crear un objeto Cliente con los datos obtenidos
            Object[] fila = resultados.get(0);
            cliente = new Cliente();
            cliente.setIdCliente(Integer.parseInt(fila[0].toString()));
            cliente.setNombre(fila[1].toString());
            cliente.setApellido(fila[2].toString());
        }
        
        return cliente;
    }
}
