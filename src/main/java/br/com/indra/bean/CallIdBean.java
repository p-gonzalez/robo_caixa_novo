package br.com.indra.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.indra.DAO.CallIdDAO;
import br.com.indra.entity.CallId;

public class CallIdBean {
	
	private CallId callId1 = new CallId();
	private List<CallId> callId = new ArrayList<CallId>();
	private CallIdDAO callidDAO = new CallIdDAO();
	
	
	public void ListarCallId(){
		
		
	}


	public CallId getCallId1() {
		return callId1;
	}


	public void setCallId1(CallId callId1) {
		this.callId1 = callId1;
	}


	public List<CallId> getCallId() {
		return callId;
	}


	public void setCallId(List<CallId> callId) {
		this.callId = callId;
	}

	
	
}
