package io.github.ericbfonseca.course.entities.enums;

public enum OrderStatus {
	
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	// Código do tipo enumerado
	private int code;
	
	// Construtor do tipo enumerado
	private OrderStatus(int code) {
		this.code = code;
	}
	
	// Método público para acessar o Enum
	public int getCode() {
		return code;
	}
	
	// Método estático (não precisa ser instanciado) para converter um valor numérico em um tipo enumerado
	public static OrderStatus valueOf(int code) {
		for (OrderStatus value : OrderStatus.values()) {
			if (value.getCode() == code)
				return value;
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
}
