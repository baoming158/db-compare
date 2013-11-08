package com.hskj.main;
import java.util.List;

import com.hskj.dbunit.Column;
import com.hskj.dbunit.DBComponent;
import com.hskj.dbunit.Schemata;
import com.hskj.dbunit.Table;
import com.hskj.util.DBSumary;


public class Comparation {
	private void ColumnComparing(Table table_base,Table table_other){
		for(Column column_base:table_base.getColumnList()){
			Column column_other = table_other.getColumnByName(column_base.getColumn_name());
			if(column_other!=null){
				//�Ƚ�����
				ColumnProComparing(column_base,column_other);
			}else{
				//�ӱ��б�ɾ��
				column_other.getRm_list().add(column_base);
			}
		}
	}
	private void ColumnProComparing(Column base, Column other) {
		if (base.getCharacter_maximum_length() == null) {
			if (other.getCharacter_maximum_length() != null){
				other.getErr_filed().add("character_maximum_length");
			}
		} else if (!base.getCharacter_maximum_length()
				.equals(other.getCharacter_maximum_length())){
			other.getErr_filed().add("character_maximum_length");
		}
		if (base.getCharacter_set_name() == null) {
			if (other.getCharacter_set_name() != null){
				other.getErr_filed().add("character_maximum_length");
			}
		} else if (!base.getCharacter_set_name().equals(other.getCharacter_set_name())){
			other.getErr_filed().add("character_maximum_length");
		}
		if (base.getCollation_name() == null) {
			if (other.getCollation_name()!= null){
				other.getErr_filed().add("character_maximum_length");
			}
		} else if (!base.getCollation_name().equals(other.getCollation_name())){
			other.getErr_filed().add("character_maximum_length");
		}
		if (base.getColumn_default() == null) {
			if (other.getColumn_default() != null){
				other.getErr_filed().add("character_maximum_length");
			}
		} else if (!base.getColumn_default().equals(other.getColumn_default())){
			other.getErr_filed().add("character_maximum_length");
		}
		if (base.getColumn_key() == null) {
			if (other.getColumn_key() != null){
				other.getErr_filed().add("character_maximum_length");
			}
		} else if (!base.getColumn_key().equals(other.getColumn_key())){
			other.getErr_filed().add("character_maximum_length");
		}
		if (base.getColumn_name() == null) {
			if (other.getColumn_name() != null){
				other.getErr_filed().add("character_maximum_length");
			}
		} else if (!base.getColumn_name().equals(other.getColumn_name())){
			other.getErr_filed().add("character_maximum_length");
		}
		if (base.getColumn_type() == null) {
			if (other.getColumn_type() != null){
				other.getErr_filed().add("character_maximum_length");
			}
		} else if (!base.getColumn_type().equals(other.getColumn_type())){
			other.getErr_filed().add("character_maximum_length");
		}
		if (base.getData_type() == null) {
			if (other.getData_type() != null)
				other.getErr_filed().add("character_maximum_length");
		} else if (!base.getData_type().equals(other.getData_type())){
			other.getErr_filed().add("character_maximum_length");
		}
		if (base.getExtra() == null) {
			if (other.getExtra() != null){
				other.getErr_filed().add("character_maximum_length");
			}
		} else if (!base.getExtra().equals(other.getExtra())){
			other.getErr_filed().add("character_maximum_length");
		}
		if (base.getIs_nullable() == null) {
			if (other.getIs_nullable() != null){
				other.getErr_filed().add("character_maximum_length");
			}
		} else if (!base.getIs_nullable().equals(other.getIs_nullable())){
			other.getErr_filed().add("character_maximum_length");
		}
		if (base.getOrdinal_position() != other.getOrdinal_position()){
			other.getErr_filed().add("character_maximum_length");
		}
		if (base.getTable_name() == null) {
			if (other.getTable_name() != null)
				other.getErr_filed().add("character_maximum_length");
		} else if (!base.getTable_name().equals(other.getTable_name())){
			other.getErr_filed().add("character_maximum_length");
		}
	}
	private String tableComparing(DBComponent base,DBComponent other){
		for(Table table_base:base.getTableList()){
			Table table_other = other.getTableByTableName(table_base.getTABLE_NAME());
			if(table_other!=null){
				//�Ƚϱ�����
				tableProComparing(table_base,table_other);
				ColumnComparing(table_base,table_other);
			}else{
				//�ӱ��б�ɾ���ı�
				table_other.getRm_list().add(table_base);
			}
		}
		//����Ƚ�
		for(Table table_other:other.getTableList()){
			Table table_base = base.getTableByTableName(table_other.getTABLE_NAME());
			if(table_base!=null){
				//��������
				ColumnComparing(table_base,table_other);
			}else{
				//�ӱ��ж���ı�
				table_other.getAdd_list().add(table_base);
			}
		}
		return null;
	}
	private void tableProComparing(Table base,Table other){
		if (base.getENGINE()== null) {
			if (other.getENGINE() != null){
				other.getErr_filed().add("ENGINE");
			}
		} else if (!base.getENGINE().equals(other.getENGINE())){
			other.getErr_filed().add("ENGINE");
		}
		if (base.getTABLE_NAME() == null) {
			if (other.getTABLE_NAME() != null){
				other.getErr_filed().add("TABLE_NAME");
			}
		} else if (!base.getTABLE_NAME().equals(other.getTABLE_NAME())){
			other.getErr_filed().add("TABLE_NAME");
		}
	}
	
	
	
	/*
	 * 
	 * �Ƚϱ��Ƿ���ͬ
	 */
	private String compareTable(DBComponent base,DBComponent other){
		String msg ="";
		for(Table table1:base.getTableList()){
			Table table2 = other.getTableByTableName(table1.getTABLE_NAME());
			if(table2!=null){
				if(!table2.equals(table1)){
//					msg +=  "���ݿ⣺"+c1.getUrl()+"��: ����"+table1.getTABLE_NAME()+ "�ṹ����ͬ\r\n";
				}
			}else{
				table1.setIs_exit(false);
				DBSumary.addTableMsg("���ݿ⣺"+other.getUrl()+"��: �����ڱ���"+table1.getTABLE_NAME()+ "\r\n");
//				msg +=  "���ݿ⣺"+c1.getUrl()+"��: ����"+table1.getTABLE_NAME()+ "������\r\n";
			}
		}
		
		return msg.equals("")?"tables   ok:�����ݱ��ṹ��������\r\n":msg;
	}
	
	private String compareColumns(DBComponent base,DBComponent other){
		String msg = "";
		System.out.println();
		for(Table table1:base.getTableList()){
			if(table1.isIs_exit()){
				List<Column> c1_column_list =  table1.getColumnList();
				for(Column column_c1:c1_column_list){
					Column column_c2 = other.getColumnByColumnName(column_c1.getTable_name(),column_c1.getColumn_name()); 
					if(column_c2!=null){
						if(!column_c1.equals(column_c2)){
							msg += "columns err:���ݿ�"+other.getUrl()+"��,��:"+table1.getTABLE_NAME()+":�ֶ�"+column_c1.getColumn_name()+"�쳣\r\n";
						}
					}else{
						DBSumary.addColumnMsg("columns err:���ݿ�"+other.getUrl()+"��,��:"+table1.getTABLE_NAME()+"�в�����"+column_c1.getColumn_name()+"�ֶ�");
						msg +="columns err:���ݿ�"+other.getUrl()+"��,��:"+table1.getTABLE_NAME()+"�в�����"+column_c1.getColumn_name()+"�ֶ�\r\n";
					}
				}
			}
		}
		return msg =  msg.equals("")?"columns   ok:�����ݱ��ֶνṹ������������\r\n":msg;
	}
	private void compare(DBComponent compareTable,DBComponent compareTable1){
		
		Comparation t = new Comparation();
		/*
		 * �Ƚ����ݿ��Ƿ���ͬ
		 */
		Schemata schemata = compareTable.getSchemata();
		Schemata schemata1 = compareTable1.getSchemata();
		schemata1.equals(schemata);
		/*
		 * 
		 * �Ƚϱ��Ƿ���ͬ
		 */
		t.compareTable(compareTable,compareTable1);
		t.compareTable(compareTable1,compareTable);
		
		/*
		 *�Ƚϱ��ֶ� 
		 */
		t.compareColumns(compareTable,compareTable1);
		t.compareColumns(compareTable1,compareTable);
		
		
	}
	
	public String compare2(DBComponent compareTable,DBComponent ...compareTables){
		String msg = "";
		if(compareTables!=null && compareTables.length>0){
			for(int i = 0;i<compareTables.length;i++){
				DBSumary.setSummary("�Ƚ�"+compareTable.getUrl()+"��"+compareTables[i].getUrl());
				compare(compareTable,compareTables[i]);
				msg += DBSumary.nextMessage()+"\r\n";
//				System.out.println(DBSumary.nextMessage());
			}
		}
		System.out.println(msg);
		return msg;
	}
	/**
	 * web �����
	 * @param compareTable
	 * @param compareTables
	 * @return
	 */
	public String compare2(DBComponent compareTable,List<DBComponent> compareTables){
		String msg = "";
		if(compareTables!=null && compareTables.size()>0){
			for(DBComponent c:compareTables){
				DBSumary.setSummary("�Ƚ�"+compareTable.getUrl()+"��"+c.getUrl());
				compare(compareTable,c);
				msg += DBSumary.nextMessage()+"\r\n";
//				System.out.println(DBSumary.nextMessage());
			}
		}
		return msg;
	}
	public static void main(String[] args) throws Exception{
		
		DBComponent compareTable = new DBComponent("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=gbk","root","root");
		
		DBComponent compareTable1 = new DBComponent("jdbc:mysql://localhost:3306/test1?useUnicode=true&characterEncoding=gbk","root","root");
		
		DBComponent compareTable2 = new DBComponent("jdbc:mysql://localhost:3306/test2?useUnicode=true&characterEncoding=gbk","root","root");
//		Comparation t = new Comparation();
//		t.compare2(compareTable,compareTable1,compareTable2);
		
		Comparation c = new Comparation();
		c.tableComparing(compareTable,compareTable);
	}
}