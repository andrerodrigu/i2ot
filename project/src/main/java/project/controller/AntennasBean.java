package project.controller;

import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import project.model.Antennas;
import project.model.User;
import project.util.JpaUtil;

@ManagedBean
@RequestScoped
public class AntennasBean {
	
	Antennas antennas = new Antennas();
	List<Antennas> antennasList;

	public Antennas getAntennas() {
		return antennas;
	}

	public void setAntennas(Antennas antennas) {
		this.antennas = antennas;
	}

	public List<Antennas> getAntennasList() {
		
		if(this.antennasList==null) {
		EntityManager em = JpaUtil.getEntityManager();
		TypedQuery<Antennas> q = em.createNamedQuery(Antennas.findByNumber, Antennas.class);
		q.setParameter("number", antennas.getNumber());
		this.antennasList = q.getResultList();
		
		em.close();
		}
		return antennasList;
	}

	public String FlameAntennaRegistry() {
		return "AntennaRegistry";
	}
	
	public void saveAntennas() {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction trx = em.getTransaction();
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			trx.begin();
			em.persist(antennas);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro efetuado.",
					"Antena " +this.getAntennas().getName() +" cadastrada com sucesso.");
			context.addMessage(null, message);
			antennas = new Antennas();
			em.getTransaction().commit();
		}catch(Exception e){
			trx.rollback();
		}finally {
			em.close();
		}
	}
	
	public void deleteAntennas(Antennas antennas){
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction trx = em.getTransaction();
		trx.begin();
		antennas = em.merge(antennas);
		em.remove(antennas);
		trx.commit();
		em.close();
	}
	
	public String searchAntennas() {
		EntityManager em = JpaUtil.getEntityManager();
		TypedQuery<Antennas> q = em.createNamedQuery(Antennas.findByNumber, Antennas.class);
		q.setParameter("number",antennas.getNumber());
		if(q.getSingleResult()!=null) {
			return "/AntennasReport.xhtml?faces-redirect=true";
		}else {
			return "/SearchAntennas.xhtml?faces-redirect=true";
		}
	}
}
