package com.hskj.main;
import java.util.List;

import com.hskj.dbunit.Column;
import com.hskj.dbunit.DBComponent;
import com.hskj.dbunit.Schemata;
import com.hskj.dbunit.Table;
import com.hskj.util.DBSumary;


public class Comparation {
	private boolean _columnComparing(Table table_base,Table table_other){
		for(Column column_base:table_base.getColumnList()){
			Column column_other = table_other.getColumnByName(column_base.getTable_name(),column_base.getColumn_name());
			if(column_other!=null){
				//�Ƚ�����
				if(_columnProComparing(column_base,column_other)){
					table_other.setModified(true);
				}
			}else{
				//�ӱ��б�ɾ��
				table_other.getRm_list().add(column_base);
				table_other.setModified(true);
			}
		}
		//����Ƚ�
		for(Column column_other:table_other.getColumnList()){
			Column column_base = table_base.getColumnByName(column_other.getTable_name(),column_other.getColumn_name());
			if(column_base!=null){
			}else{
				//�ӱ�������
				column_other.setIs_extra_column(true);
				table_other.setModified(true);
			}
		}
		return table_other.isModified();
	}
	/**
	 * 
	 * @param base
	 * @param other
	 * @return true:�б仯 false�ޱ仯
	 */
	private boolean _columnProComparing(Column base, Column other) {
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
				other.getErr_filed().add("character_set_name");
			}
		} else if (!base.getCharacter_set_name().equals(other.getCharacter_set_name())){
			other.getErr_filed().add("character_set_name");
		}
		if (base.getCollation_name() == null) {
			if (other.getCollation_name()!= null){
				other.getErr_filed().add("collation_name");
			}
		} else if (!base.getCollation_name().equals(other.getCollation_name())){
			other.getErr_filed().add("collation_name");
		}
		if (base.getColumn_default() == null) {
			if (other.getColumn_default() != null){
				other.getErr_filed().add("column_default");
			}
		} else if (!base.getColumn_default().equals(other.getColumn_default())){
			other.getErr_filed().add("column_default");
		}
		if (base.getColumn_key() == null) {
			if (other.getColumn_key() != null){
				other.getErr_filed().add("column_key");
			}
		} else if (!base.getColumn_key().equals(other.getColumn_key())){
			other.getErr_filed().add("column_key");
		}
		if (base.getColumn_name() == null) {
			if (other.getColumn_name() != null){
				other.getErr_filed().add("column_name");
			}
		} else if (!base.getColumn_name().equals(other.getColumn_name())){
			other.getErr_filed().add("column_name");
		}
		if (base.getColumn_type() == null) {
			if (other.getColumn_type() != null){
				other.getErr_filed().add("column_type");
			}
		} else if (!base.getColumn_type().equals(other.getColumn_type())){
			other.getErr_filed().add("column_type");
		}
		if (base.getData_type() == null) {
			if (other.getData_type() != null)
				other.getErr_filed().add("data_type");
		} else if (!base.getData_type().equals(other.getData_type())){
			other.getErr_filed().add("data_type");
		}
		if (base.getExtra() == null) {
			if (other.getExtra() != null){
				other.getErr_filed().add("extra");
			}
		} else if (!base.getExtra().equals(other.getExtra())){
			other.getErr_filed().add("extra");
		}
		if (base.getIs_nullable() == null) {
			if (other.getIs_nullable() != null){
				other.getErr_filed().add("is_nullable");
			}
		} else if (!base.getIs_nullable().equals(other.getIs_nullable())){
			other.getErr_filed().add("is_nullable");
		}
		if (base.getOrdinal_position() != other.getOrdinal_position()){
			other.getErr_filed().add("ordinal_position");
		}
		if (base.getTable_name() == null) {
			if (other.getTable_name() != null)
				other.getErr_filed().add("table_name");
		} else if (!base.getTable_name().equals(other.getTable_name())){
			other.getErr_filed().add("table_name");
		}
		if(other.getErr_filed()!=null&&other.getErr_filed().size()>0){
			other.setBase_column(base);
			return true;
		}
		return false;
	}
	public void _getMessage(DBComponent component){
		System.out.println();
		System.out.println("-------------------------"+component.getDbname()+"----------------------------");
		for(String e:component.getSchemata().getErr_filed()){
			System.out.println("*���Բ��죺"+e);
		}
		for(Table t:component.getRm_list()){
			System.out.println("-��"+t.getTABLE_NAME());
		}
		for(Table t :component.getTableList()){
			System.out.println("-------------------------"+t.getTABLE_NAME()+"----------------------------");
			if(t.isIs_extra_table()){
				System.out.println("�˱�Ϊ����ı�");
				break;
			}
			for(Column c:t.getRm_list()){
				System.out.println("-ȱ���У�"+c.getColumn_name());
			}
			for(Column c:t.getColumnList()){
				if(c.isIs_extra_column()){
					System.out.println("+�������"+c.getColumn_name());
				}
			}
			for(Column c:t.getColumnList()){
				if(c.getErr_filed().size()>0){
					System.out.println("�ֶ�"+c.getColumn_name()+"�����Բ�ͬ��������"+c.getErr_filed());
				}
			}
		}
	}
	private static void _schemataProComparing(Schemata base,Schemata other){
		if (base.getDEFAULT_CHARACTER_SET_NAME() == null) {
			if (other.getDEFAULT_CHARACTER_SET_NAME() != null)
				other.getErr_filed().add("DEFAULT_CHARACTER_SET_NAME");
		} else if (!base.getDEFAULT_CHARACTER_SET_NAME()
				.equals(other.getDEFAULT_CHARACTER_SET_NAME())){
			other.getErr_filed().add("DEFAULT_CHARACTER_SET_NAME");
		}
		if (base.getDEFAULT_COLLATION_NAME() == null) {
			if (other.getDEFAULT_COLLATION_NAME() != null){
				other.getErr_filed().add("DEFAULT_COLLATION_NAME");
			}
		} else if (!base.getDEFAULT_COLLATION_NAME().equals(other.getDEFAULT_COLLATION_NAME())){
			other.getErr_filed().add("DEFAULT_COLLATION_NAME");
		}
	}
	public String _start(DBComponent base,DBComponent other){
		_schemataProComparing(base.getSchemata(),other.getSchemata());
		for(Table table_base:base.getTableList()){
			Table table_other = other.getTableByTableName(table_base.getTABLE_NAME());
			if(table_other!=null){
				//�Ƚϱ�����
				if(_tableProComparing(table_base,table_other)){
					other.setModified(true);
				}
				if(_columnComparing(table_base,table_other)){
					other.setModified(true);
				}
			}else{
				//�ӱ��б�ɾ���ı�
				other.getRm_list().add(table_base);
			}
		}
		//����Ƚ�
		for(Table table_other:other.getTableList()){
			Table table_base = base.getTableByTableName(table_other.getTABLE_NAME());
			if(table_base!=null){
				//�������
			}else{
				//�ӱ��ж���ı�
				table_other.setIs_extra_table(true);
			}
		}
		return null;
	}
	public void _compare(DBComponent compareTable,List<DBComponent> compareTables){
		if(compareTables!=null && compareTables.size()>0){
			for(DBComponent c:compareTables){
				DBSumary.setSummary("�Ƚ�"+compareTable.getUrl()+"��"+c.getUrl());
				_start(compareTable,c);
				_getMessage(c);
			}
		}
	}
	private boolean _tableProComparing(Table base,Table other){
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
		if(other.getErr_filed()!=null&&other.getErr_filed().size()>0){
			other.setBase_table(base);
			other.setModified(true);
		}
		if(other.isModified()){
			return true;
		}else{
			return false;
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
//					msg +=  "���ݿ⣺"+c1.getUrl()+"��: ��"+table1.getTABLE_NAME()+ "�ṹ����ͬ\r\n";
				}
			}else{
				table1.setIs_exit(false);
				DBSumary.addTableMsg("���ݿ⣺"+other.getUrl()+"��: �����ڱ�"+table1.getTABLE_NAME()+ "\r\n");
//				msg +=  "���ݿ⣺"+c1.getUrl()+"��: ��"+table1.getTABLE_NAME()+ "������\r\n";
			}
		}
		
		return msg.equals("")?"tables   ok:�����ݱ�ṹ��������\r\n":msg;
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
		c._start(compareTable,compareTable2);
		c._getMessage(compareTable2);
	}
}
