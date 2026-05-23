package br.com.fiap;

import br.com.fiap.bo.DentistaBO;
import br.com.fiap.entities.Dentista;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.sql.SQLException;
import java.util.ArrayList;

@Path("/dentista")
public class DentistaResource {

    private DentistaBO dentistaBO = new DentistaBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Dentista> selecionarRs() throws ClassNotFoundException, SQLException {
        return (ArrayList<Dentista>) dentistaBO.selecionarBo();
    }

    @GET
    @Path("/{cro}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarPorCroRs(@PathParam("cro") String cro) throws ClassNotFoundException, SQLException {
        Dentista dentista = dentistaBO.buscarPorDentistaBO(cro); // CORRIGIDO: Passando a string direto, sem Integer.parseInt

        if (dentista == null) {
            return Response.status(Response.Status.NOT_FOUND).build(); // Retorna 404 se não achar o CRO
        }
        return Response.ok(dentista).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Dentista dentista, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
        dentistaBO.inserirBo(dentista);

        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(dentista.getCro());

        return Response.created(builder.build()).build();
    }


    @PUT
    @Path("/{cro}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Dentista dentista, @PathParam("cro") String cro) throws ClassNotFoundException, SQLException {
        dentista.setCro(cro);
        dentistaBO.atualizarBo(dentista);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{cro}") // CORRIGIDO: Passando {cro} na URL
    public Response deletarRs(@PathParam("cro") String cro) throws ClassNotFoundException, SQLException {
        dentistaBO.deletarBo(cro);
        return Response.ok().build();
    }
}