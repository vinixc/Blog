package br.com.blueclover.blog.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "postagens")
public class Postagem  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2675884570124103647L;
	
	@Id
	@SequenceGenerator(name = "seqPostagens", initialValue = 1, sequenceName = "seqPostagens", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seqPostagens")
	@Column(name = "ID_AVATAR")
	private Long id;
	
	@Column(nullable = false, unique = true, length = 60)
	private String titulo;
	
	@Column(nullable = false, columnDefinition = "TEXT")
	private String texto;
	
	@Column(nullable = false, unique = true, length = 60)
	private String permalink;
	
	@Column(name = "data_postagem", nullable = false)
	private LocalDateTime dataPostagem;
	
	@ManyToOne
	@JoinColumn(name = "autor_id")
	private Autor autor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getPermalink() {
		return permalink;
	}

	public void setPermalink(String permalink) {
		this.permalink = permalink;
	}

	public LocalDateTime getDataPostagem() {
		return dataPostagem;
	}

	public void setDataPostagem(LocalDateTime dataPostagem) {
		this.dataPostagem = dataPostagem;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Postagem other = (Postagem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Postagem [id=" + id + ", titulo=" + titulo + ", texto=" + texto + ", permalink=" + permalink
				+ ", dataPostagem=" + dataPostagem + ", autor=" + autor + "]";
	}
	
	

}