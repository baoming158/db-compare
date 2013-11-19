package com.hskj.main;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

import com.hskj.dbunit.Column;
import com.hskj.dbunit.DBComponent;
import com.hskj.dbunit.Schemata;
import com.hskj.dbunit.Table;


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
	public void _consolePrint(DBComponent component){
		System.out.println();
		System.out.println("*************************���ݿ⣺��"+component.getDbname()+"("+component.getUrl()+")��*************************");
		if(component.getSchemata().getErr_filed()!=null&& component.getSchemata().getErr_filed().size()>0){
			System.out.print("\t(*)���ݿ����Բ��죺");
			for(String e:component.getSchemata().getErr_filed()){
				System.out.print(e);
			}
			System.out.println();
		}
		if(component.getRm_list()!=null && component.getRm_list().size()>0){
			System.out.print("\t(-)�����ڵı�");
			for(Table t:component.getRm_list()){
				System.out.print(t.getTABLE_NAME()+"\t");
			}
			System.out.println();
		}
		for(Table t :component.getTableList()){
			if(t.isModified()){
				System.out.print("\t(*)���ڲ���ı�:");
				System.out.println("��"+t.getTABLE_NAME()+"��");
				if(t.isIs_extra_table()){
					System.out.println("\t\t\t(+)�˱�Ϊ����ı�");
				}else{
					if(t.getErr_filed()!=null&&t.getErr_filed().size()>0){
						System.out.println("\t\t\t���죺"+t.getErr_filed());
					}
					for(Column c:t.getRm_list()){
						System.out.println("\t\t\t-ȱ���У�"+c.getColumn_name());
					}
					for(Column c:t.getColumnList()){
						if(c.isIs_extra_column()){
							System.out.println("\t\t\t+�������"+c.getColumn_name());
						}
					}
					for(Column c:t.getColumnList()){
						if(c.getErr_filed().size()>0){
							System.out.println("\t\t\t�ֶ�"+c.getColumn_name()+"�����Բ�ͬ��"+c.getErr_filed());
						}
					}
				}
			}
		}
	}
	public void _fileWrite(DBComponent component,String path) throws Exception{
		if(path==null){
			path="d:/diff_result.txt";
		}
		Writer out = null;
		try {
			File file = new File(path);
			out = new PrintWriter(new FileWriter(file,true));
			out.write("*************************���ݿ⣺��"+component.getDbname()+"("+component.getUrl()+")��*************************\r\n");
			if(component.getSchemata().getErr_filed()!=null&& component.getSchemata().getErr_filed().size()>0){
				out.write("\t(*)���ݿ����Բ��죺");
				for(String e:component.getSchemata().getErr_filed()){
					out.write(e);
				}
				out.write("\r\n");
			}
			if(component.getRm_list()!=null && component.getRm_list().size()>0){
				out.write("\t(-)�����ڵı�");
				for(Table t:component.getRm_list()){
					out.write(t.getTABLE_NAME()+"\t");
				}
				out.write("\r\n");
			}
			for(Table t :component.getTableList()){
				if(t.isModified()){
					out.write("\t(*)���ڲ���ı�:");
					out.write("��"+t.getTABLE_NAME()+"��\r\n");
					if(t.isIs_extra_table()){
						out.write("\t\t\t(+)�˱�Ϊ����ı�\r\n");
					}else{
						if(t.getErr_filed()!=null&&t.getErr_filed().size()>0){
							out.write("\t\t\t���죺"+t.getErr_filed()+"\r\n");
						}
						for(Column c:t.getRm_list()){
							out.write("\t\t\t-ȱ���У�"+c.getColumn_name()+"\r\n");
						}
						for(Column c:t.getColumnList()){
							if(c.isIs_extra_column()){
								out.write("\t\t\t+�������"+c.getColumn_name()+"\r\n");
							}
						}
						for(Column c:t.getColumnList()){
							if(c.getErr_filed().size()>0){
								out.write("\t\t\t�ֶ�"+c.getColumn_name()+"�����Բ�ͬ��"+c.getErr_filed()+"\r\n");
							}
						}
					}
				}
			}
			out.write("\r\n");
			out.flush();
		} finally{
			out.close();
		}
	}
	/**
	 * �ȽϿ����� ��ͬ�򷵻�true ����ͬ����false
	 * @param base
	 * @param other
	 * @return
	 */
	private static boolean _schemataProComparing(Schemata base,Schemata other){
		boolean bool = true;
		if (base.getDEFAULT_CHARACTER_SET_NAME() == null) {
			if (other.getDEFAULT_CHARACTER_SET_NAME() != null){
				other.getErr_filed().add("DEFAULT_CHARACTER_SET_NAME");
				bool = false;
			}
		} else if (!base.getDEFAULT_CHARACTER_SET_NAME()
				.equals(other.getDEFAULT_CHARACTER_SET_NAME())){
			other.getErr_filed().add("DEFAULT_CHARACTER_SET_NAME");
			bool = false;
		}
		if (base.getDEFAULT_COLLATION_NAME() == null) {
			if (other.getDEFAULT_COLLATION_NAME() != null){
				other.getErr_filed().add("DEFAULT_COLLATION_NAME");
				bool = false;
			}
		} else if (!base.getDEFAULT_COLLATION_NAME().equals(other.getDEFAULT_COLLATION_NAME())){
			other.getErr_filed().add("DEFAULT_COLLATION_NAME");
			bool = false;
		}
		return bool;
	}
	
	/**
	 * �Ƚ�����������������Ƿ���ͬ true Ϊ��ͬ falseΪ����ͬ
	 * @param base
	 * @param other
	 * @return
	 */
	public boolean _start(DBComponent base,DBComponent other){
		if(!_schemataProComparing(base.getSchemata(),other.getSchemata())){
			other.setModified(true);
		}
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
				other.setModified(true);
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
				table_other.setModified(true);
				other.setModified(true);
			}
		}
		return other.isModified();
	}
	public void _compare(DBComponent compareTable,List<DBComponent> compareTables){
		if(compareTables!=null && compareTables.size()>0){
			for(DBComponent c:compareTables){
				_start(compareTable,c);
//				_getDiffMessage(c);
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
	
	
	
	
	
}
