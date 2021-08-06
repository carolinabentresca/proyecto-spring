/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Config.Conexion;
import Entidad.usuario;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author EXO
 */
@Controller
public class Controlador {
  
    Conexion conexion = new Conexion();
    JdbcTemplate jdbcTemplate = new JdbcTemplate(conexion.Conectar());
    ModelAndView mv = new ModelAndView();
    List datos;
    int id;
    
    @RequestMapping("index.htm")
    public ModelAndView listar(){
       String sql = "select * from usuario" ;
       datos = this.jdbcTemplate.queryForList(sql);
       mv.addObject("lista",datos);
       mv.setViewName("index");
       return mv;
    }
    
    @RequestMapping(value= "agregar.htm", method= RequestMethod.GET)
    public ModelAndView agregar(){
       mv.addObject(new usuario());
       mv.setViewName("agregar");
       return mv;
    }
    
      
    @RequestMapping(value= "agregar.htm", method= RequestMethod.POST)
    public ModelAndView agregar(usuario us){
       String sql = "insert into usuario(id,nombre,email)values(?,?,?)";
       this.jdbcTemplate.update(sql,us.getId(),us.getNombre(),us.getEmail());
       return new ModelAndView("redirect:/index.htm");
    }
    
      
    @RequestMapping(value= "editar.htm", method= RequestMethod.GET)
    public ModelAndView editar(HttpServletRequest request){
       id = Integer.parseInt(request.getParameter("id"));
       String sql = "select * from usuario where id = " + id;
       datos = this.jdbcTemplate.queryForList(sql);
       mv.addObject("lista", datos);
       mv.setViewName("editar");
       return mv;
    }
    
    
    @RequestMapping(value= "editar.htm", method= RequestMethod.POST)
    public ModelAndView editar(usuario us){
        String sql = "update usuario set nombre = ?, email = ? where id = ? " ;
        this.jdbcTemplate.update(sql ,us.getNombre(),us.getEmail(),us.getId());
       return new ModelAndView("redirect:/index.htm");
    }
      
    @RequestMapping(value= "eliminar.htm", method= RequestMethod.GET)
    public ModelAndView eliminar(HttpServletRequest request){
        id = Integer.parseInt(request.getParameter("id"));
        String sql = "delete from usuario where id = " + id;
        this.jdbcTemplate.update(sql);
       return new ModelAndView("redirect:/index.htm");
    }
    
}
