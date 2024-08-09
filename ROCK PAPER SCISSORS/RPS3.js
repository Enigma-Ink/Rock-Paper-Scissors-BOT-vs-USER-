let botScore = 0;
let userScore = 0;
let drawScore = 0;

function play(userChoice) {
    const choices = ['Rock', 'Paper', 'Scissors'];
    const botChoice = choices[Math.floor(Math.random() * choices.length)];
    
    let result = '';
    if (userChoice === botChoice) {
        result = "It's a draw!";
        drawScore++;
    } else if (
        (userChoice === 'Rock' && botChoice === 'Scissors') ||
        (userChoice === 'Paper' && botChoice === 'Rock') ||
        (userChoice === 'Scissors' && botChoice === 'Paper')
    ) {
        result = "You win!";
        userScore++;
    } else {
        result = "Bot wins!";
        botScore++;
    }
    
    document.getElementById('result').innerText = `Bot chose ${botChoice}. ${result}`;
    document.getElementById('bot-score').innerText = botScore;
    document.getElementById('draw-score').innerText = drawScore;
    document.getElementById('user-score').innerText = userScore;
}
