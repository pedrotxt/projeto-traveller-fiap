package dao;

// Interface do DAO é generica
// Podendo ser para Usuario, Cliente, qualquer um poderá usar este DAO generico
public interface DAO<T extends Object> {
	
	// Operações genericas
	public void create(T object);
	public T read(T object);
	public void update(T object);
	public void delete(T object);

}
