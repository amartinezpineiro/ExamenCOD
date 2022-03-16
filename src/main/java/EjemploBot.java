import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.MessageChannel;

public class EjemploBot {
    public static void main(final String[] args) {
        final String token = "OTUzNjI4NTg3Njg3Mjg0NzM2.YjHV1A.SEwLO_D5dmRAGR6sfNKbe6qx1Fo";//Se crea una variable String para almacenar el token
        final DiscordClient client = DiscordClient.create(token);//Se crea el cliente utilizado el token
        final GatewayDiscordClient gateway = client.login().block();//Se crea una pasarela usando el cliente

        gateway.on(MessageCreateEvent.class).subscribe(event -> {
            final Message message = event.getMessage();//Se crea una variable Message para recivir el mensage recivido
            if ("!ping".equals(message.getContent())) {//Comprobacion de si el mensaje recivido equivale a !ping
                final MessageChannel channel = message.getChannel().block();
                channel.createMessage("Pong!").block();//Se crea el mensaje de respuesta Pong!
            }
        });

        gateway.onDisconnect().block();//Se cierra la pasarela
    }
}
