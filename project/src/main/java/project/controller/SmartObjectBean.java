package project.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import project.model.DepartmentType;
import project.model.SmartObject;
import project.model.SmartObjectSearchType;
import project.model.User;
import project.util.BusinessException;
import project.util.JpaUtil;

@ManagedBean
@RequestScoped
public class SmartObjectBean {

	SmartObject smartObject = new SmartObject();
	
	private List<SmartObject> smartObjects;

	public SmartObject getSmartObject() {
		return smartObject;
	}
	
	public void setSmartObject(SmartObject smartObject) {
		this.smartObject = smartObject;
	}
	
	public List<SmartObject> getSmartObjects() {
		if(this.smartObject==null) {
			EntityManager em = JpaUtil.getEntityManager();
			TypedQuery<SmartObject> q = em.createNamedQuery(SmartObject.findByItem, SmartObject.class);
			this.smartObjects = q.getResultList();
			em.close();
			}
				return smartObjects;
	}
	
	public String FlameSmartObjectRegister() {
		return "SmartObjectRegister";
	}
	
	public String FlameSmartObjectReport() {
		return "SmartObjectReport";
	}
	
	public SelectItem[] getSmartObjectSearchType() {
	    SelectItem[] items = new SelectItem[SmartObjectSearchType.values().length];
	    int i = 0;
	    for(SmartObjectSearchType t: SmartObjectSearchType.values()) {
	        items[i++] = new SelectItem(t, t.getSmartObjectSearchType());
	    }
	    return items;
	}
	
	public void saveSmartObject() throws BusinessException {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction trx = em.getTransaction();
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			trx.begin();
			em.persist(smartObject);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro efetuado.",
					"Objeto " +this.getSmartObject().getItem() +" cadastrado com sucesso.");
			context.addMessage(null, message);
			smartObject = new SmartObject();
			em.getTransaction().commit();
		}finally {
			em.close();
		}
		
	}
	
	public String SearchSmartObject() {
		EntityManager em = JpaUtil.getEntityManager();
		TypedQuery<SmartObject> q = em.createNamedQuery(SmartObject.findByItem, SmartObject.class);
		q.setParameter("item", smartObject.getItem());
		System.out.println(q.getSingleResult());
		if(q.getSingleResult()!=null) {
			System.out.println("Objeto encontrado!");
			return "Objeto encontrado!";
		}else {
			System.out.println("Usuário não encontrado");
		}
		return "Objeto não encontrado!";
	}
	
	public void deleteSmartObject(SmartObject smartObject){
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction trx = em.getTransaction();
		trx.begin();
		smartObject = em.merge(smartObject);
		em.remove(smartObject);
		trx.commit();
		em.close();
	}
}
